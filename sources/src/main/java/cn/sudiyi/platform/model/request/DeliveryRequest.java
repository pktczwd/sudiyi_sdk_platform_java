package cn.sudiyi.platform.model.request;

import cn.sudiyi.platform.model.BoxType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class DeliveryRequest {

    //设备ID
    @JsonProperty(value = "device_id", required = true)
    private String deviceId;

    @JsonProperty("box_type")
    private BoxType boxType;

    //回调地址
    @JsonProperty(value = "notify_url", required = true)
    private String notifyUrl;

    //第三方订单号
    @JsonProperty("order_no")
    private String orderNo;

    //取件人手机号
    @JsonProperty("consignee_mobile")
    private String consigneeMobile;

    //订单金额
    @JsonProperty("cargo_price")
    private BigDecimal cargoPrice;

    //期望取货时间
    @JsonProperty("expected_fetch_time")
    private Long expectedFetchTime;

    @JsonProperty("shop_no")
    private Integer shopNo;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getConsigneeMobile() {
        return consigneeMobile;
    }

    public void setConsigneeMobile(String consigneeMobile) {
        this.consigneeMobile = consigneeMobile;
    }

    public BigDecimal getCargoPrice() {
        return cargoPrice;
    }

    public void setCargoPrice(BigDecimal cargoPrice) {
        this.cargoPrice = cargoPrice;
    }

    public Long getExpectedFetchTime() {
        return expectedFetchTime;
    }

    public void setExpectedFetchTime(Long expectedFetchTime) {
        this.expectedFetchTime = expectedFetchTime;
    }

    public Integer getShopNo() {
        return shopNo;
    }

    public void setShopNo(Integer shopNo) {
        this.shopNo = shopNo;
    }
}
