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

package cn.sudiyi.platform;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import cn.sudiyi.platform.common.json.JSONConverter;
import cn.sudiyi.platform.common.utils.IOUtils;
import cn.sudiyi.platform.model.callback.OrderStatusCallback;
import cn.sudiyi.platform.model.callback.ReservationCallback;

/**
 * 回调消息解析器.
 * @author pankai
 * Dec 11, 2015
 */
public class CallbackParser {

    private static final String CHARSET_UTF8 = "UTF-8";

    /**
     * 解析预约回调
     * @param request HttpServletRequest
     * @return 预约回调结果{@link ReservationCallback}
     * @throws IOException IOException
     */
    public ReservationCallback parseReservationCallback(HttpServletRequest request) throws IOException {
        String requestBody = new String(IOUtils.bytes(request.getInputStream()), Charset.forName(CHARSET_UTF8));
        return JSONConverter.fromJson(ReservationCallback.class, requestBody);
    }

    /**
     * 解析订单状态回调
     * @param request HttpServletRequest
     * @return 订单状态回调结果{@link OrderStatusCallback}
     * @throws IOException IOException
     */
    public OrderStatusCallback parseOrderStatusCallback(HttpServletRequest request) throws IOException {
        String requestBody = new String(IOUtils.bytes(request.getInputStream()), Charset.forName(CHARSET_UTF8));
        return JSONConverter.fromJson(OrderStatusCallback.class, requestBody);
    }

}
