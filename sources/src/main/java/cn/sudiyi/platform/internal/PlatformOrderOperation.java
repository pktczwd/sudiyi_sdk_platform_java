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

import cn.sudiyi.platform.ClientException;
import cn.sudiyi.platform.ServiceException;
import cn.sudiyi.platform.common.auth.CredentialsProvider;
import cn.sudiyi.platform.common.comm.ServiceClient;
import cn.sudiyi.platform.common.http.*;
import cn.sudiyi.platform.common.json.JSONConverter;
import cn.sudiyi.platform.common.parser.ResponseParseException;
import cn.sudiyi.platform.common.parser.ResponseParser;
import cn.sudiyi.platform.common.utils.CodingUtils;
import cn.sudiyi.platform.model.BoxType;
import cn.sudiyi.platform.model.request.*;
import cn.sudiyi.platform.model.response.DeliveryResponse;
import cn.sudiyi.platform.model.response.GetDeadlettersResponse;
import cn.sudiyi.platform.model.response.QueryReservationResponse;
import cn.sudiyi.platform.model.response.ReserveResponse;

/**
 * 订单操作
 *
 * @author pankai
 *         Dec 10, 2015
 */
public class PlatformOrderOperation extends PlatformOperation {

    public PlatformOrderOperation(ServiceClient client, CredentialsProvider credsProvider) {
        super(client, credsProvider);
    }

    public ReserveResponse reserve(ReserveRequest request) {

        CodingUtils.assertParameterNotNull(request, "reserveRequest");
        CodingUtils.assertStringNotNullOrEmpty(request.getDeviceId(), "reserveRequest.deviceId");
        CodingUtils.assertParameterNotNull(request.getBoxType(), "reserveRequest.boxType");
        CodingUtils.assertStringNotNullOrEmpty(request.getNotifyUrl(), "reserveRequest.notifyUrl");
        CodingUtils.assertStringNotNullOrEmpty(request.getSenderMobile(), "reserveRequest.senderMobile");
        CodingUtils.assertStringNotNullOrEmpty(request.getOrderNo(), "reserveRequest.orderNo");
        CodingUtils.assertStringNotNullOrEmpty(request.getConsigneeMobile(), "reserveRequest.consigneeMobile");

        String url = new StringBuilder(getEndpoint().toString()).append("/v1/resv").toString();
        TextPost post = new TextPost(url);
        post.setBody(JSONConverter.toJson(request));
        return doOperation(post, new ResponseParser<ReserveResponse>() {

            @Override
            public ReserveResponse parse(HttpResponse response) throws ResponseParseException {
                HttpStatusCode statusCode = response.getStatusCode();
                if (!statusCode.isSuccess()) {
                    if (420 == statusCode.getStatusCode()) {
                        throw new ServiceException("请求过于频繁!");
                    } else if (421 == statusCode.getStatusCode()) {
                        throw new ServiceException("超过预约上限!");
                    } else {
                        throw new ServiceException(CodingUtils.parseUnexpectedResponse(response));
                    }
                }
                return JSONConverter.fromJson(ReserveResponse.class, response.getResponseText());
            }
        });
    }

    public ReserveResponse reserveV2(ReserveRequestV2 request) {

        CodingUtils.assertParameterNotNull(request, "reserveRequest");
        CodingUtils.assertStringNotNullOrEmpty(request.getDeviceId(), "reserveRequest.deviceId");
        CodingUtils.assertParameterNotNull(request.getBoxType(), "reserveRequest.boxType");
        if (request.getBoxType().equals(BoxType.ICE)) {
            throw new ClientException("Unsupported box type: ice.");
        }
        CodingUtils.assertStringNotNullOrEmpty(request.getNotifyUrl(), "reserveRequest.notifyUrl");
        CodingUtils.assertStringNotNullOrEmpty(request.getSenderMobile(), "reserveRequest.senderMobile");
        CodingUtils.assertStringNotNullOrEmpty(request.getOrderNo(), "reserveRequest.orderNo");

        String url = new StringBuilder(getEndpoint().toString()).append("/v2/resv").toString();
        TextPost post = new TextPost(url);
        post.setBody(JSONConverter.toJson(request));
        return doOperation(post, new ResponseParser<ReserveResponse>() {

            @Override
            public ReserveResponse parse(HttpResponse response) throws ResponseParseException {
                HttpStatusCode statusCode = response.getStatusCode();
                if (!statusCode.isSuccess()) {
                    if (420 == statusCode.getStatusCode()) {
                        throw new ServiceException("请求过于频繁!");
                    } else if (421 == statusCode.getStatusCode()) {
                        throw new ServiceException("超过预约上限!");
                    } else {
                        throw new ServiceException(CodingUtils.parseUnexpectedResponse(response));
                    }
                }
                return JSONConverter.fromJson(ReserveResponse.class, response.getResponseText());
            }
        });
    }


    public Boolean cancelReserve(CancelReservationRequest request) {

        CodingUtils.assertParameterNotNull(request, "cancelReserveRequest");
        CodingUtils.assertParameterNotNull(request.getReserveOrderId(), "cancelReserveRequest.reserveOrderId");

        String url = new StringBuilder(getEndpoint().toString()).append("/v1/resv").append("/").append(request.getReserveOrderId().toString()).toString();
        Delete delete = new Delete(url);
        return doOperation(delete, new ResponseParser<Boolean>() {

            @Override
            public Boolean parse(HttpResponse response) throws ResponseParseException {
                HttpStatusCode statusCode = response.getStatusCode();
                if (200 == statusCode.getStatusCode()) {
                    return Boolean.TRUE;
                } else if (204 == statusCode.getStatusCode()) {
                    return Boolean.FALSE;
                } else {
                    throw new ServiceException(CodingUtils.parseUnexpectedResponse(response));
                }
            }
        });
    }

    public QueryReservationResponse queryReservation(QueryReservationRequest request) {

        CodingUtils.assertParameterNotNull(request, "queryReservationRequest");
        CodingUtils.assertParameterNotNull(request, "queryReservationRequest.reserveOrderId");

        String url = new StringBuilder(getEndpoint().toString()).append("/v1/resv").append("/").append(request.getReserveOrderId().toString()).toString();
        Get get = new Get(url);
        return doOperation(get, new ResponseParser<QueryReservationResponse>() {

            @Override
            public QueryReservationResponse parse(HttpResponse response) throws ResponseParseException {
                HttpStatusCode statusCode = response.getStatusCode();
                if (204 == statusCode.getStatusCode()) {
                    throw new ServiceException("订单号不存在!");
                }
                return JSONConverter.fromJson(QueryReservationResponse.class, response.getResponseText());
            }
        });

    }

    public GetDeadlettersResponse getDeadletters() {
        String url = new StringBuilder(getEndpoint().toString()).append("/v1/deadletter").toString();
        Get get = new Get(url);
        return doOperation(get, new ResponseParser<GetDeadlettersResponse>() {

            @Override
            public GetDeadlettersResponse parse(HttpResponse response) throws ResponseParseException {
                return JSONConverter.fromJson(GetDeadlettersResponse.class, response.getResponseText());
            }
        });
    }

    public DeliveryResponse delivery(DeliveryRequest request) {

        CodingUtils.assertParameterNotNull(request, "deliveryRequest");
        CodingUtils.assertStringNotNullOrEmpty(request.getDeviceId(), "deliveryRequest.deviceId");
        CodingUtils.assertParameterNotNull(request.getBoxType(), "deliveryRequest.boxType");
        CodingUtils.assertStringNotNullOrEmpty(request.getNotifyUrl(), "deliveryRequest.notifyUrl");
        CodingUtils.assertStringNotNullOrEmpty(request.getOrderNo(), "deliveryRequest.orderNo");
        CodingUtils.assertStringNotNullOrEmpty(request.getConsigneeMobile(), "deliveryRequest.consigneeMobile");
        CodingUtils.assertParameterNotNull(request.getShopNo(), "deliveryRequest.shopNo");
        CodingUtils.assertParameterNotNull(request.getExpectedFetchTime(), "deliveryRequest.expectedFetchTime");
        CodingUtils.assertParameterNotNull(request.getCargoPrice(), "deliveryRequest.cargoPrice");


        String url = new StringBuilder(getEndpoint().toString()).append("/v1/deli").toString();
        TextPost post = new TextPost(url);
        post.setBody(JSONConverter.toJson(request));
        return doOperation(post, new ResponseParser<DeliveryResponse>() {
            @Override
            public DeliveryResponse parse(HttpResponse response) throws ResponseParseException {
                return JSONConverter.fromJson(DeliveryResponse.class, response.getResponseText());
            }
        });
    }

}
