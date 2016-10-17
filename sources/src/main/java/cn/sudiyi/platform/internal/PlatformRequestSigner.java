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
import java.nio.charset.Charset;
import java.util.Date;

import cn.sudiyi.platform.ClientException;
import cn.sudiyi.platform.common.auth.Credentials;
import cn.sudiyi.platform.common.auth.RequestSigner;
import cn.sudiyi.platform.common.crypto.HMAC;
import cn.sudiyi.platform.common.crypto.HMAC.Hash;
import cn.sudiyi.platform.common.crypto.MD5;
import cn.sudiyi.platform.common.http.Delete;
import cn.sudiyi.platform.common.http.Get;
import cn.sudiyi.platform.common.http.HttpRequest;
import cn.sudiyi.platform.common.http.TextPost;
import cn.sudiyi.platform.common.utils.Base64;

/**
 * 请求签名方法.
 * @author pankai
 * Dec 9, 2015
 */
public class PlatformRequestSigner implements RequestSigner {

    private final Credentials creds;
    private final URI endpoint;
    private static final String LINE_BREAK = "\n";
    private static final String DEFAULT_CONTENT_TYPE = "application/json;charset=UTF-8";

    public PlatformRequestSigner(Credentials creds, URI endpoint) {
        this.creds = creds;
        this.endpoint = endpoint;
    }

    @Override
    public void sign(HttpRequest request) throws ClientException {
        String url = request.getUrl();
        String nowString = getNowString();
        String contentMD5 = null;
        String infoToSign = null;
        if (request instanceof Get) {
            contentMD5 = buildContentMD5("");
            infoToSign = buildInfoToSign("get", contentMD5, DEFAULT_CONTENT_TYPE, nowString, url.replace(this.endpoint.toString(), ""));
        } else if (request instanceof TextPost) {
            TextPost post = (TextPost) request;
            contentMD5 = buildContentMD5(post.getBody());
            infoToSign = buildInfoToSign("post", contentMD5, DEFAULT_CONTENT_TYPE, nowString, url.replace(this.endpoint.toString(), ""));
        } else if (request instanceof Delete) {
            contentMD5 = buildContentMD5("");
            infoToSign = buildInfoToSign("delete", contentMD5, DEFAULT_CONTENT_TYPE, nowString, url.replace(this.endpoint.toString(), ""));
        } else {
            throw new UnsupportedOperationException("Invalid HttpRequest type!");
        }
        request.addHeader("Content-MD5", contentMD5);
        request.addHeader("Authorization", buildAuthorization(creds.getAccessKeyId(), creds.getSecretAccessKey(), infoToSign));
        request.addHeader("Content-Type", DEFAULT_CONTENT_TYPE);
        request.addHeader("Date", nowString);
    }

    /**
     * 生成Authorization
     */
    private String buildAuthorization(String sdyPartnerId, String sdyPartnerSecret, String infoToSign) {
        HMAC hmac = new HMAC();
        hmac.setHash(Hash.SHA1);
        hmac.setSecretKey(sdyPartnerSecret.getBytes(Charset.forName("UTF-8")));
        String signature = Base64.getEncoder().encodeToString(hmac.digest(infoToSign));
        String authorization = new StringBuilder().append("SDY ").append(sdyPartnerId).append(":").append(signature).toString();
        return authorization;
    }

    /**
     * 生成Content-MD5
     * 
     * @algorithm Base64(MD5(request-content))
     */
    private String buildContentMD5(String requestBody) {
        MD5 md5 = new MD5();
        String contentMD5 = md5.encrypt(requestBody);
        String result = Base64.getEncoder().encodeToString(contentMD5.getBytes());
        return result;
    }

    /**
     * 生成infoToSign
     */
    private String buildInfoToSign(String method, String contentMD5, String contentType, String date, String uri) {
        StringBuilder sb = new StringBuilder().append(method.toUpperCase()).append(LINE_BREAK).append(contentMD5).append(LINE_BREAK).append(contentType).append(LINE_BREAK).append(date).append(
                LINE_BREAK).append(uri);
        String result = sb.toString();
        return result;
    }

    private String getNowString() {
        return new Date(System.currentTimeMillis()).toString();
    }
}
