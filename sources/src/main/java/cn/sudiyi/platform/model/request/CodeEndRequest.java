package cn.sudiyi.platform.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pktczwd on 2016/11/15.
 */
public class CodeEndRequest {

    @JsonProperty("reservation_id")
    private Long reservationId;
    @JsonProperty("open_code")
    private String openCode;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }
}
