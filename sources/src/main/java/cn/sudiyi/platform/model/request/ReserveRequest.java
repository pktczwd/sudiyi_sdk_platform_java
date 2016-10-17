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
import cn.sudiyi.platform.model.BoxType;
import cn.sudiyi.platform.model.OverduePayType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 预约请求
 * @see Platform#reserve(ReserveRequest)
 * @author pankai
 * Dec 9, 2015
 */
public class ReserveRequest {
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
     * 是否可以自动升箱;非必填;默认否
     */
    @JsonProperty("auto_upgd")
    private Boolean autoUpgrade = Boolean.FALSE;
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
     * 取件人手机号;必填
     */
    @JsonProperty("consignee_mobile")
    private String consigneeMobile;
    /**
     * 取件人姓名;非必填
     */
    @JsonProperty("consignee_name")
    private String consigneeName;
    /**
     * 到付金额,非必填
     */
    private Integer payment;
    /**
     * 预约时长;单位分钟
     */
    private Integer duration = new Integer(240);
    /**
     * 超期支付方式
     */
    @JsonProperty("pay_type")
    private OverduePayType payType;

    /**
     * 描述;非必填
     */
    @JsonProperty("desc")
    private String description;

    /**
     * 返回设备id
     * @return 设备id 
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备id
     * @param deviceId 设备id
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 返回箱格类型{@link BoxType}
     * @return 箱格类型{@link BoxType}
     */
    public BoxType getBoxType() {
        return boxType;
    }

    /**
     * 设置箱格类型{@link BoxType}
     * @param boxType 箱格类型{@link BoxType}
     */
    public void setBoxType(BoxType boxType) {
        this.boxType = boxType;
    }

    /**
     * 返回回调地址
     * @return 回调地址
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 设置回调地址
     * @param notifyUrl 回调地址
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    /**
     * 返回是否进行了升箱
     * @return 是否进行了升箱
     */
    public Boolean getAutoUpgrade() {
        return autoUpgrade;
    }

    /**
     * 设置是否进行了升箱
     * @param autoUpgrade 是否进行了升箱
     */
    public void setAutoUpgrade(Boolean autoUpgrade) {
        this.autoUpgrade = autoUpgrade;
    }

    /**
     * 返回投件人姓名
     * @return 投件人姓名
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * 设置投件人姓名
     * @param senderName 投件人姓名
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     * 返回投件人手机号
     * @return 投件人手机号
     */
    public String getSenderMobile() {
        return senderMobile;
    }

    /**
     * 设置投件人手机号
     * @param senderMobile 投件人手机号
     */
    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    /**
     * 返回商户订单号
     * @return 商户订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置商户订单号
     * @param orderNo 商户订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 返回收件人手机号
     * @return 收件人手机号
     */
    public String getConsigneeMobile() {
        return consigneeMobile;
    }

    /**
     * 设置收件人手机号
     * @param consigneeMobile 收件人手机号
     */
    public void setConsigneeMobile(String consigneeMobile) {
        this.consigneeMobile = consigneeMobile;
    }

    /**
     * 返回收件人姓名
     * @return 收件人姓名
     */
    public String getConsigneeName() {
        return consigneeName;
    }

    /**
     * 设置收件人姓名
     * @param consigneeName 收件人姓名
     */
    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    /**
     * 返回到付金额
     * @return 到付金额
     */
    public Integer getPayment() {
        return payment;
    }

    /**
     * 设置到付金额
     * @param payment 到付金额
     */
    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    /**
     * 返回预约时长
     * @return 预约时长
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 设置预约时长
     * @param duration 预约时长
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 返回超期费支付方式{@link OverduePayType}}
     * @return 超期费支付方式{@link OverduePayType}}
     */
    public OverduePayType getPayType() {
        return payType;
    }

    /**
     * 设置超期费支付方式{@link OverduePayType}}
     * @param payType 超期费支付方式{@link OverduePayType}}
     */
    public void setPayType(OverduePayType payType) {
        this.payType = payType;
    }

    /**
     * 返回描述
     * @return 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
