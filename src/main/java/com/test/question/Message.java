package com.test.question;

public class Message {

    public Message(String url) {
        this.url = url;
        this.stop = false;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    private String url;
    private Boolean stop;
}
