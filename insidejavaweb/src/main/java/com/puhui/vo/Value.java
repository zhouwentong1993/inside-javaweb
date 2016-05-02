package com.puhui.vo;

/**
 * Created by wentong on 2016/4/28.
 */
public class Value {
    private Long id;
    private String requestUrl;
    private String port;
    private Long timeStamp;

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", requestUrl='" + requestUrl + '\'' +
                ", port='" + port + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
