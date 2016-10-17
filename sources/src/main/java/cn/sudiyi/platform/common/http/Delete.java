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
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class Delete extends HttpRequest {

    private List<NameValuePair> parameters;

    public Delete(String url) {
        super(url);
    }

    public void addParameter(String key, String value) {
        if (parameters == null) {
            parameters = new ArrayList<NameValuePair>();
        }
        parameters.add(new BasicNameValuePair(key, value));
    }

    @Override
    HttpRequestBase createRequest() {
        String completedURL = createURL();
        return new HttpDelete(completedURL);
    }

    private String createURL() {
        if (parameters != null) {
            String queryChar = url.contains("?") ? "&" : "?";
            return new StringBuilder(url).append(queryChar).append(URLEncodedUtils.format(parameters, HTTP.DEF_CONTENT_CHARSET)).toString();
        }
        return url;
    }

}
