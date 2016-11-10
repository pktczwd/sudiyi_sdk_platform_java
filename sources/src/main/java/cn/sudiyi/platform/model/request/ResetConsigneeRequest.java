package cn.sudiyi.platform.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pktczwd on 2016/11/8.
 */
public class ResetConsigneeRequest {
    @JsonProperty("client_tel")
    private String clientTel;
    private String uuid;

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
