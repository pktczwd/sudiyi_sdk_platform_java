package cn.sudiyi.platform.model.response;

import cn.sudiyi.platform.model.request.DeliveryRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 配送响应
 * Created by pktczwd on 2016/10/26.
 *
 * @see Platform#delivery(DeliveryRequest)
 */
public class DeliveryResponse {

    /**
     * (预约)(配送)订单号
     */
    @JsonProperty("resv_order_no")
    private Long reserveOrderId;

    /**
     * 返回(预约)(配送)订单号
     *
     * @return (预约)(配送)订单号
     */
    public Long getReserveOrderId() {
        return reserveOrderId;
    }

    /**
     * 设置(预约)(配送)订单号
     *
     * @param reserveOrderId (预约)(配送)订单号
     */
    public void setReserveOrderId(Long reserveOrderId) {
        this.reserveOrderId = reserveOrderId;
    }
}
