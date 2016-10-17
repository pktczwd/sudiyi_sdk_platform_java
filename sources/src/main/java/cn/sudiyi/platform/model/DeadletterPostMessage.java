package cn.sudiyi.platform.model;

import cn.sudiyi.platform.model.response.GetDeadlettersResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 死信post消息,失败的预约成功的消息
 * @see GetDeadlettersResponse
 * @author pankai
 * 2016年1月20日
 */
public class DeadletterPostMessage {

    /**
     * 预约结果
     */
    private String result;
    /**
     * 是否进行了升箱
     */
    private Boolean upgraded;

    /**
     * (预约)订单号
     */
    @JsonProperty("resv_order_no")
    private Long reserveOrderId;

    /**
     * 箱格类型
     */
    @JsonProperty("box_type")
    private BoxType boxType;

    /**
     * 箱格序号
     */
    @JsonProperty("box_no")
    private Integer boxNo;

    /**
     * 预约码
     */
    @JsonProperty("resv_code")
    private String reservationCode;

    /**
     * 商户订单号
     */
    @JsonProperty("order_no")
    private String orderNo;

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
     * 返回预约结果
     * 预约结果包含
     * success 预约成功
     * fail 预约失败，失败原因是箱格已满。
     * timeout 预约超时，超时原因一般是快递柜断网，快递柜超时未响应。
     * @return 预约结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置预约结果
     * @param result 预约结果
     */
    public void setResult(String result) {
        this.result = result;
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
     * 返回是否进行了升箱
     * @return 是否进行了升箱
     */
    public Boolean getUpgraded() {
        return upgraded;
    }

    /**
     * 设置是否进行了升箱
     * @param upgraded 是否进行了升箱
     */
    public void setUpgraded(Boolean upgraded) {
        this.upgraded = upgraded;
    }

    /**
     * 返回箱格序号
     * @return 箱格序号
     */
    public Integer getBoxNo() {
        return boxNo;
    }

    /**
     * 设置箱格序号
     * @param boxNo 箱格序号
     */
    public void setBoxNo(Integer boxNo) {
        this.boxNo = boxNo;
    }

    /**
     * 返回预约码
     * @return 预约码
     */
    public String getReservationCode() {
        return reservationCode;
    }

    /**
     * 设置预约码
     * @param reservationCode 预约码
     */
    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

}
