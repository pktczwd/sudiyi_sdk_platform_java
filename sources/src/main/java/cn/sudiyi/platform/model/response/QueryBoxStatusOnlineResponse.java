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

package cn.sudiyi.platform.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.sudiyi.platform.model.BoxAvailableStat;

/**
 * 查询箱格状态和设备在线状态响应
 * @author pankai
 * 2016年3月11日
 */
public class QueryBoxStatusOnlineResponse {

    /**
     * 设备id
     */
    @JsonProperty("device")
    private Integer deviceId;
    /**
     * 可预约的箱格数量
     */
    private BoxAvailableStat status;

    /**
     * 返回设备id
     * @return 设备id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备id
     * @param deviceId 设备id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 返回可预约的箱格数量
     * @return 可预约的箱格数量
     */
    public BoxAvailableStat getStatus() {
        return status;
    }

    /**
     * 设置可预约的箱格数量
     * @param status 可预约的箱格数量
     */
    public void setStatus(BoxAvailableStat status) {
        this.status = status;
    }

}
