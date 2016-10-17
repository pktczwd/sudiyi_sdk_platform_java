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

package cn.sudiyi.platform.internal;

import java.net.URI;

import cn.sudiyi.platform.ClientException;
import cn.sudiyi.platform.PlatformException;
import cn.sudiyi.platform.common.auth.CredentialsProvider;
import cn.sudiyi.platform.common.auth.RequestSigner;
import cn.sudiyi.platform.common.comm.ExecutionContext;
import cn.sudiyi.platform.common.comm.NoRetryStrategy;
import cn.sudiyi.platform.common.comm.RetryStrategy;
import cn.sudiyi.platform.common.comm.ServiceClient;
import cn.sudiyi.platform.common.http.Get;
import cn.sudiyi.platform.common.http.HttpRequest;
import cn.sudiyi.platform.common.http.HttpResponse;
import cn.sudiyi.platform.common.parser.ResponseParseException;
import cn.sudiyi.platform.common.parser.ResponseParser;
import cn.sudiyi.platform.common.utils.ExceptionFactory;
import cn.sudiyi.platform.common.utils.LogUtils;

public abstract class PlatformOperation {

    private volatile URI endpoint;
    private CredentialsProvider credsProvider;
    private ServiceClient client;
    private RequestSigner signer;

    private static RetryStrategy noRetryStrategy = new NoRetryStrategy();

    protected PlatformOperation(ServiceClient client, CredentialsProvider credsProvider) {
        this.client = client;
        this.credsProvider = credsProvider;
    }

    protected <T> T doOperation(HttpRequest request, ResponseParser<T> parser) throws PlatformException, ClientException {
        ExecutionContext context = createDefaultContext(request);
        HttpResponse response = client.sendRequest(request, context);
        try {
            return parser.parse(response);
        } catch (ResponseParseException e) {
            LogUtils.logException("Unable to parse response error: ", e);
            PlatformException pe = ExceptionFactory.createInvalidResponseException("Unable to parse response:" + response.getResponseText(), e);
            throw pe;
        }
    }

    private ExecutionContext createDefaultContext(HttpRequest request) {
        ExecutionContext context = new ExecutionContext();
        if (!(request instanceof Get)) {
            context.setRetryStrategy(noRetryStrategy);
        }
        context.setSigner(signer);
        return context;
    }

    protected ServiceClient getInnerClient() {
        return this.client;
    }

    public URI getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(URI endpoint) {
        this.endpoint = URI.create(endpoint.toString());
        initRequestSigner();
    }

    private void initRequestSigner() {
        this.signer = new PlatformRequestSigner(this.credsProvider.getCredentials(), endpoint);
    }

}
