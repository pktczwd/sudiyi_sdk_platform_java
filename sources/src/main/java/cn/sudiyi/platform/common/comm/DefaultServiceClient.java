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

import cn.sudiyi.platform.ClientConfiguration;
import cn.sudiyi.platform.ClientException;
import cn.sudiyi.platform.ServiceException;
import cn.sudiyi.platform.common.http.HttpHeaders;
import cn.sudiyi.platform.common.http.HttpRequest;
import cn.sudiyi.platform.common.http.HttpResponse;
import cn.sudiyi.platform.common.http.HttpStatusCode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class DefaultServiceClient extends ServiceClient {

    private static HttpClientFactory httpClientFactory = new HttpClientFactory();

    private CloseableHttpClient httpClient;

    public DefaultServiceClient(ClientConfiguration config) {
        super(config);
        httpClient = httpClientFactory.createHttpClient(this.config);
    }

    @Override
    public HttpResponse sendRequestCore(HttpRequest request, ExecutionContext context) {
        try {
            CloseableHttpResponse response = executeMethod(request);
            HttpStatusCode statusCode = new HttpStatusCode(response.getStatusLine().getStatusCode());
            String responseText = readResponseText(response);
            validateStatusCode(statusCode, responseText);
            HttpHeaders headers = HttpHeaders.createResponseHearders(response);
            return new HttpResponse(statusCode, headers, responseText);
        } catch (IOException e) {
            throw new ClientException(e);
        }
    }

    @Override
    protected void close() throws IOException {
        this.httpClient.close();
    }

    private CloseableHttpResponse executeMethod(HttpRequest request) throws IOException {
        HttpRequestBase httpRequest = request.createHttpRequest();
        return httpClient.execute(httpRequest);
    }

    private String readResponseText(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        return null != entity ? EntityUtils.toString(entity, "UTF-8") : "";
    }

    private void validateStatusCode(HttpStatusCode statusCode, String responseText) {
        if (HttpStatus.SC_FORBIDDEN == statusCode.getStatusCode()) {
            throw new ServiceException("无效的AccessId/AccessKey!");
        }
        if (HttpStatus.SC_INTERNAL_SERVER_ERROR == statusCode.getStatusCode()) {
            throw new ServiceException("服务端错误,请稍后再试.");
        }
        if (HttpStatus.SC_BAD_REQUEST == statusCode.getStatusCode()) {
            throw new ServiceException("无效的请求:" + responseText);
        }
        if (!statusCode.isSuccess()) {
            throw new ServiceException("未定义的服务端响应,请稍后再试.响应码为:" + statusCode.getStatusCode());
        }
    }

    @Override
    protected RetryStrategy getDefaultRetryStrategy() {
        return new DefaultRetryStrategy();
    }

    private static class DefaultRetryStrategy extends RetryStrategy {

        @Override
        public boolean shouldRetry(Exception exception, HttpRequest request, HttpResponse response, int retries) {
            //TODO 某些Exception也可重试.
            if (null != response) {
                int statusCode = response.getStatusCode().getStatusCode();
                if (statusCode == HttpStatus.SC_SERVICE_UNAVAILABLE) {
                    return true;
                }
            }
            return false;
        }
    }

}
