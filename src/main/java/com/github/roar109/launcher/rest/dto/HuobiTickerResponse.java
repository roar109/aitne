package com.github.roar109.launcher.rest.dto;

public class HuobiTickerResponse {
    private String status;
    private HuobiTickerPayload tick;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HuobiTickerPayload getTick() {
        return tick;
    }

    public void setTick(HuobiTickerPayload tick) {
        this.tick = tick;
    }
}
