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

import cn.sudiyi.platform.model.BoxType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 预约请求v2
 */
public class ReserveRequestV2 {
    /**
     * 速递易设备id;必填
     */
    @JsonProperty("device_id")
    private String deviceId;
    /**
     * 箱格类型;必填
     */
    @JsonProperty("box_type")
    private BoxType boxType;
    /**
     * 回调地址;必填
     */
    @JsonProperty("notify_url")
    private String notifyUrl;
    /**
     * 投件人姓名;非必填;默认空
     */
    @JsonProperty("sender_name")
    private String senderName;
    /**
     * 投件人手机;必填
     */
    @JsonProperty("sender_mobile")
    private String senderMobile;
    /**
     * 商户订单号;必填
     */
    @JsonProperty("order_no")
    private String orderNo;
    /**
     * 预约时长;单位分钟
     */
    private Integer duration = new Integer(240);

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public BoxType getBoxType() {
        return boxType;
    }

    public void setBoxType(BoxType boxType) {
        this.boxType = boxType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMobile() {
        return senderMobile;
    }

    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
