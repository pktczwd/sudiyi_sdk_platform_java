package cn.sudiyi.platform.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pktczwd on 2016/11/20.
 */
public class FreeRequest {

    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("thirdparty_id")
    private Integer thirdpartyId;
    private Integer threshold;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getThirdpartyId() {
        return thirdpartyId;
    }

    public void setThirdpartyId(Integer thirdpartyId) {
        this.thirdpartyId = thirdpartyId;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}
