package cn.sudiyi.platform.model.request;

import cn.sudiyi.platform.model.BoxType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pktczwd on 2016/11/14.
 */
public class ReserveRequestV3 {

    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("box_type")
    private BoxType boxType;
    @JsonProperty("open_code_count")
    private Integer openCodeCount;
    @JsonProperty("order_no")
    private String orderNo;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("notify_url")
    private String notifyUrl;

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

    public Integer getOpenCodeCount() {
        return openCodeCount;
    }

    public void setOpenCodeCount(Integer openCodeCount) {
        this.openCodeCount = openCodeCount;
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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
