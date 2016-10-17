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

package cn.sudiyi.platform.common.http;

import org.apache.http.client.methods.HttpRequestBase;

public abstract class HttpRequest {

    protected final String url;
    private final HttpHeaders headers = new HttpHeaders();

    protected HttpRequest(String url) {
        this.url = url;
    }

    public void setAccept(String contentType) {
        this.headers.add("Accept", contentType);
    }

    public void addHeader(String name, String value) {
        this.headers.add(name, value);
    }

    public HttpRequestBase createHttpRequest() {
        HttpRequestBase request = createRequest();
        this.headers.addHeadersToRequest(request);
        return request;
    }

    abstract HttpRequestBase createRequest();

    public String getUrl() {
        return url;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

}
