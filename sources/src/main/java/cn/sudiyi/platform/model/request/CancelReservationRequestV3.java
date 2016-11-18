package cn.sudiyi.platform.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pktczwd on 2016/11/15.
 */
public class CancelReservationRequestV3 {

    @JsonProperty("reservation_id")
    private Long reservationId;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
