package cn.sudiyi.platform.model;

import cn.sudiyi.platform.model.response.GetDeadlettersResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 死信put信息,失败的箱格状态变化的信息
 * @see GetDeadlettersResponse
 * @author pankai
 * 2016年1月20日
 */
public class DeadletterPutMessage {

    /**
     * 订单状态
     */
    @JsonProperty("status")
    private OrderStatus orderStatus;

    /**
     * (预约)订单号
     */
    @JsonProperty("resv_order_no")
    private Long reserveOrderId;
    /**
     * 开箱码
     */
    @JsonProperty("open_code")
    private String openCode;

    /**
     * 返回(预约)订单状态{@link OrderStatus}
     * @return (预约)订单状态{@link OrderStatus}
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置(预约)订单状态{@link OrderStatus}
     * @param orderStatus (预约)订单状态{@link OrderStatus}
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

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
