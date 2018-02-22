package me.jodoin.mining.pool.notification;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientShowMessageNotification extends JsonRpcNotification {

    public static final String METHOD_NAME = "client.show_message";

    @JsonIgnore
    private String message;

    public ClientShowMessageNotification() {
        super(METHOD_NAME);
    }

    public ClientShowMessageNotification(JsonRpcNotification notification) {
        super(notification);
    }

    @Override
    public List<Object> getParams() {
        if (super.getParams() == null) {
            List<Object> params = new ArrayList<Object>();
            super.setParams(params);
            params.add(message);
        }
        return super.getParams();
    }

    @Override
    public void setParams(List<Object> params) {
        super.setParams(params);
        if (params != null) {
            message = (String) params.get(0);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
