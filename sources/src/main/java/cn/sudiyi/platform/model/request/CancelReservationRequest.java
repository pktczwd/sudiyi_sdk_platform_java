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

package cn.sudiyi.platform.model.request;

import cn.sudiyi.platform.Platform;

/**
 * 取消预约请求
 * @see Platform#cancelReserve(CancelReservationRequest)
 * @author pankai
 * Dec 10, 2015
 */
public class CancelReservationRequest {

    /**
     * (预约)订单编号
     */
    private Long reserveOrderId;

    /**
     * 返回(预约)订单编号
     * @return (预约)订单编号
     */
    public Long getReserveOrderId() {
        return reserveOrderId;
    }

    /**
     * 设置(预约)订单编号
     * @param reserveOrderId (预约)订单编号
     */
    public void setReserveOrderId(Long reserveOrderId) {
        this.reserveOrderId = reserveOrderId;
    }

}
