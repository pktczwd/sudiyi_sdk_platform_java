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

package cn.sudiyi.platform.model;

/**
 * (预约)订单状态
 * @author pankai
 * Dec 11, 2015
 */
public enum OrderStatus {

    /**
     * 未定义
     */
    UNDEFINED, //
    /**
     * 正在预约
     */
    RESERVING, //
    /**
     * 预约成功,等待投件
     */
    RESERVED, //
    /**
     * 预约失败
     */
    FAILED, //
    /**
     * 预约超时
     */
    RESERVATION_OVERDUE, //
    /**
     * 已投件
     */
    POSTED, //
    /**
     * 已取件
     */
    PICKED, //
    /**
     * 投递超时
     */
    POST_OVERDUE, //
    /**
     * 已取消
     */
    CANCELLED, //
    /**
     * 值守取给取件人
     */
    TO_RECEIVER, //
    /**
     * 值守取给投件人
     */
    TO_SENDER, //
    /**
     * 值守暂存
     */
    STASHED;

}
