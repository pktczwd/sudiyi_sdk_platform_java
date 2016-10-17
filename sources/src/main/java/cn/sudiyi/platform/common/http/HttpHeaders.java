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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

public class HttpHeaders {

    private List<HttpHeader> headers;

    public static HttpHeaders createResponseHearders(HttpResponse response) {
        Header[] rawHeaders = response.getAllHeaders();
        List<HttpHeader> httpHeaders = new ArrayList<HttpHeader>(rawHeaders.length);
        for (Header header : rawHeaders) {
            httpHeaders.add(new HttpHeader(header.getName(), header.getValue()));
        }
        HttpHeaders headers = new HttpHeaders();
        headers.headers = Collections.unmodifiableList(httpHeaders);
        return headers;
    }

    public void add(String name, String value) {
        if (this.headers == null)
            this.headers = new ArrayList<HttpHeader>();
        this.headers.add(new HttpHeader(name, value));
    }

    public void addHeadersToRequest(HttpRequestBase request) {
        if (this.headers != null)
            for (HttpHeader header : this.headers)
                request.addHeader(header.getName(), header.getValue());
    }

}
