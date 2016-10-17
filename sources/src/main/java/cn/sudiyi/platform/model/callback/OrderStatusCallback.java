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

package cn.sudiyi.platform.model.callback;

import cn.sudiyi.platform.CallbackParser;
import cn.sudiyi.platform.model.OrderStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * (预约)订单状态回调结果
 * @see CallbackParser#parseOrderStatusCallback(javax.servlet.http.HttpServletRequest)
 * @author pankai
 * Dec 11, 2015
 */
public class OrderStatusCallback {

    /**
     * 预约订单号
     */
    @JsonProperty("resv_order_no")
    private Long reserveOrderId;
    /**
     * 订单状态
     */
    @JsonProperty("status")
    private OrderStatus status;
    /**
     * 开箱码
     */
    @JsonProperty("open_code")
    private String openCode;

    /**
     * 返回(预约)订单号
     * @return (预约)订单号
     */
    public Long getReserveOrderId() {
        return reserveOrderId;
    }

    /**
     * 设置(预约)订单号
     * @param reserveOrderId (预约)订单号
     */
    public void setReserveOrderId(Long reserveOrderId) {
        this.reserveOrderId = reserveOrderId;
    }

    /**
     * 返回(预约)订单状态{@link OrderStatus}
     * @return (预约)订单状态{@link OrderStatus}
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * 设置(预约)订单状态{@link OrderStatus}
     * @param status (预约)订单状态{@link OrderStatus}
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * 返回开箱码
     * @return 开箱码
     */
    public String getOpenCode() {
        return openCode;
    }

    /**
     * 设置开箱码
     * @param openCode 开箱码
     */
    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }

}
