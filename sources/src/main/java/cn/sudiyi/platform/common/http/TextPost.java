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

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.StringEntity;

import cn.sudiyi.platform.common.utils.StringUtils;

public class TextPost extends HttpRequest {

    private String body;
    private String contentType = "text/plain";
    private boolean chunked;

    public TextPost(String url) {
        super(url);
    }

    @Override
    HttpRequestBase createRequest() {
        HttpPost post = new HttpPost(this.url);
        if (StringUtils.isNotBlank(this.body)) {
            AbstractHttpEntity entity = new StringEntity(this.body, "UTF-8");
            entity.setContentType(this.contentType + "; charset=" + "UTF-8");
            entity.setChunked(this.chunked);
            post.setEntity(entity);
        }
        return post;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean isChunked() {
        return chunked;
    }

    public void setChunked(boolean chunked) {
        this.chunked = chunked;
    }

}
