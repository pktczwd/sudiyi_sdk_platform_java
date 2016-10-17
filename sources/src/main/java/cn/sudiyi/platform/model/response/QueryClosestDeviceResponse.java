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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 查询附近设备响应
 * @author pankai
 * 2016年3月14日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryClosestDeviceResponse {

    /**
     * 设备id
     */
    @JsonProperty("id")
    private Integer deviceId;
    /**
     * 设备名称
     */
    @JsonProperty("name")
    private String deivceName;
    /**
     * 设备地址
     */
    private String address;
    /**
     * 设备经度
     */
    @JsonProperty("lng")
    private Double longitude;
    /**
     * 设备纬度
     */
    @JsonProperty("lat")
    private Double latitude;
    /**
     * 距离,单位:米
     */
    private Integer distance;

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
     * 返回设备名称
     * @return 设备名称
     */
    public String getDeivceName() {
        return deivceName;
    }

    /**
     * 设置设备名称
     * @param deivceName 设备名称
     */
    public void setDeivceName(String deivceName) {
        this.deivceName = deivceName;
    }

    /**
     * 返回设备地址
     * @return 设备地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置设备地址
     * @param address 设置设备地址 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 返回设备经度
     * @return 设备经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置设备经度
     * @param longitude 设备经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 返回设备纬度
     * @return 设备纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置设备纬度
     * @param latitude 设备纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 返回距离
     * @return 距离
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * 设置距离
     * @param distance 距离
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

}
