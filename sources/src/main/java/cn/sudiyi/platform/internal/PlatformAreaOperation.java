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

import java.util.List;

import cn.sudiyi.platform.common.auth.CredentialsProvider;
import cn.sudiyi.platform.common.comm.ServiceClient;
import cn.sudiyi.platform.common.http.Get;
import cn.sudiyi.platform.common.http.HttpResponse;
import cn.sudiyi.platform.common.json.JSONConverter;
import cn.sudiyi.platform.common.parser.ResponseParseException;
import cn.sudiyi.platform.common.parser.ResponseParser;
import cn.sudiyi.platform.model.Province;

public class PlatformAreaOperation extends PlatformOperation {

    public PlatformAreaOperation(ServiceClient client, CredentialsProvider credsProvider) {
        super(client, credsProvider);
    }

    public List<Province> getAdministrativeDivision() {
        String url = new StringBuilder(getEndpoint().toString()).append("/v1/area").toString();
        return doOperation(new Get(url), new ResponseParser<List<Province>>() {

            @SuppressWarnings("unchecked")
            @Override
            public List<Province> parse(HttpResponse response) throws ResponseParseException {
                return JSONConverter.fromJson(List.class, response.getResponseText(), Province.class);
            }
        });
    }
}
