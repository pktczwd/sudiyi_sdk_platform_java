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
import cn.sudiyi.platform.common.utils.CodingUtils;
import cn.sudiyi.platform.model.request.QueryBoxStatusRequest;
import cn.sudiyi.platform.model.request.QueryClosestDeviceRequest;
import cn.sudiyi.platform.model.response.QueryBoxStatusOnlineResponse;
import cn.sudiyi.platform.model.response.QueryBoxStatusResponse;
import cn.sudiyi.platform.model.response.QueryClosestDeviceResponse;

public class PlatformDeviceOperation extends PlatformOperation {

    public PlatformDeviceOperation(ServiceClient client, CredentialsProvider credsProvider) {
        super(client, credsProvider);
    }

    public QueryBoxStatusResponse queryBoxStatus(QueryBoxStatusRequest request) {

        CodingUtils.assertParameterNotNull(request, "queryBoxStatusRequest");
        CodingUtils.assertParameterNotNull(request.getId(), "queryBoxStatusRequest.id");

        Get get = new Get(new StringBuilder(getEndpoint().toString()).append("/v1/boxStatus").toString());
        get.addParameter("device", request.getId().toString());
        return doOperation(get, new ResponseParser<QueryBoxStatusResponse>() {

            @Override
            public QueryBoxStatusResponse parse(HttpResponse response) throws ResponseParseException {
                return JSONConverter.fromJson(QueryBoxStatusResponse.class, response.getResponseText());
            }
        });
    }

    public List<QueryBoxStatusOnlineResponse> queryBoxStatusOnline(QueryBoxStatusRequest request) {

        CodingUtils.assertParameterNotNull(request, "queryBoxStatusRequest");
        CodingUtils.assertParameterNotNull(request.getId(), "queryBoxStatusRequest.id");

        Get get = new Get(new StringBuilder(getEndpoint().toString()).append("/v1/boxStatus/online").toString());
        get.addParameter("device", request.getId().toString());
        return doOperation(get, new ResponseParser<List<QueryBoxStatusOnlineResponse>>() {

            @SuppressWarnings("unchecked")
            @Override
            public List<QueryBoxStatusOnlineResponse> parse(HttpResponse response) throws ResponseParseException {
                return JSONConverter.fromJson(List.class, response.getResponseText(), QueryBoxStatusOnlineResponse.class);
            }
        });
    }

    public List<QueryClosestDeviceResponse> queryClosest(QueryClosestDeviceRequest request) {

        CodingUtils.assertParameterNotNull(request, "queryClosestDeviceRequest");
        CodingUtils.assertParameterNotNull(request.getLongitude(), "queryClosestDeviceRequest.longitude");
        CodingUtils.assertParameterNotNull(request.getLatitude(), "queryClosestDeviceRequest.latitude");

        Get get = new Get(new StringBuilder(getEndpoint().toString()).append("/v1/closest").toString());
        get.addParameter("lat", request.getLatitude().toString());
        get.addParameter("lng", request.getLongitude().toString());

        return doOperation(get, new ResponseParser<List<QueryClosestDeviceResponse>>() {

            @SuppressWarnings("unchecked")
            @Override
            public List<QueryClosestDeviceResponse> parse(HttpResponse response) throws ResponseParseException {
                return JSONConverter.fromJson(List.class, response.getResponseText(), QueryClosestDeviceResponse.class);
            }
        });

    }
}
