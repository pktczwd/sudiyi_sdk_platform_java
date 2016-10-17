/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package cn.sudiyi.platform.common.comm;

import java.io.IOException;
import java.util.List;

import cn.sudiyi.platform.ClientConfiguration;
import cn.sudiyi.platform.ClientException;
import cn.sudiyi.platform.ServiceException;
import cn.sudiyi.platform.common.http.HttpRequest;
import cn.sudiyi.platform.common.http.HttpResponse;
import cn.sudiyi.platform.common.utils.CodingUtils;
import cn.sudiyi.platform.common.utils.LogUtils;
import cn.sudiyi.platform.internal.PlatformUtils;

/**
 * 抽象服务客户端.
 * @author pankai
 * Dec 3, 2015
 */
public abstract class ServiceClient {

    protected ClientConfiguration config = new ClientConfiguration();

    protected ServiceClient(ClientConfiguration config) {
        this.config = config;
    }

    public ClientConfiguration getClientConfiguration() {
        return config;
    }

    public HttpResponse sendRequest(HttpRequest request, ExecutionContext context) throws ServiceException, ClientException {
        CodingUtils.assertParameterNotNull(request, "request");
        CodingUtils.assertParameterNotNull(context, "context");

        RetryStrategy retryStrategy = context.getRetryStrategy() != null ? context.getRetryStrategy() : this.getDefaultRetryStrategy();
        if (context.getSigner() != null) {
            context.getSigner().sign(request);
        }

        int retries = 0;
        HttpResponse response = null;
        while (true) {
            try {
                if (retries > 0) {
                    pause(retries, retryStrategy);
                }
                handleRequest(request, context.getRequestHandlers());
                response = sendRequestCore(request, context);
                handleResponse(response, context.getResponseHandlers());
                return response;
            } catch (ServiceException e) {
                LogUtils.logException("[Server]Unable to execute HTTP request: ", e);
                if (!shouldRetry(e, request, response, retries, retryStrategy)) {
                    throw e;
                }
            } catch (ClientException e) {
                LogUtils.logException("[Client]Unable to execute HTTP request: ", e);
                if (!shouldRetry(e, request, response, retries, retryStrategy)) {
                    throw e;
                }
            } catch (Exception e) {
                LogUtils.logException("[Unknown]Unable to execute HTTP request: ", e);
                throw new ClientException(PlatformUtils.COMMON_RESOURCE_MANAGER.getFormattedString("ConnectionError", e.getMessage()), e);
            } finally {
                retries++;
            }
        }
    }

    private void pause(int retries, RetryStrategy retryStrategy) throws ClientException {
        long delay = retryStrategy.getPauseDelay(retries);
        LogUtils.getLog().debug("An retriable error request will be retried after " + delay + "(ms) with attempt times: " + retries);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new ClientException(e.getMessage(), e);
        }
    }

    private void handleRequest(HttpRequest request, List<RequestHandler> requestHandlers) throws ServiceException, ClientException {
        for (RequestHandler requestHandler : requestHandlers) {
            requestHandler.handle(request);
        }
    }

    private void handleResponse(HttpResponse response, List<ResponseHandler> responseHandlers) throws ServiceException, ClientException {
        for (ResponseHandler responseHandler : responseHandlers) {
            responseHandler.handle(response);
        }
    }

    private boolean shouldRetry(Exception exception, HttpRequest request, HttpResponse response, int retries, RetryStrategy retryStrategy) {
        if (retries >= config.getMaxErrorRetry()) {
            return false;
        }
        if (retryStrategy.shouldRetry(exception, request, response, retries)) {
            LogUtils.getLog().debug("Retrying on " + exception.getClass().getName() + ": " + exception.getMessage());
            return true;
        }
        return false;
    }

    protected abstract HttpResponse sendRequestCore(HttpRequest request, ExecutionContext context);

    protected abstract RetryStrategy getDefaultRetryStrategy();

    protected abstract void close() throws IOException;

}
