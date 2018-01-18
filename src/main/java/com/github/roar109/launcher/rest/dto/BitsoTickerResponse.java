package com.github.roar109.launcher.rest.dto;

public class BitsoTickerResponse {

    private boolean success;
    private BitsoTickerPayload payload;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public BitsoTickerPayload getPayload() {
        return payload;
    }

    public void setPayload(BitsoTickerPayload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "BitsoTickerResponse{" +
                "success=" + success +
                ", payload=" + payload +
                '}';
    }
}
