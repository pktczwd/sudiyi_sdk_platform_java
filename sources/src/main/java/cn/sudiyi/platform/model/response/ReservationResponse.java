package cn.sudiyi.platform.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pktczwd on 2016/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationResponse {

    @JsonProperty("reservation_id")
    private Long reservationId;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
