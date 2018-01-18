package com.github.roar109.launcher.event.dto;

public class DecreaseEvent {
    private String tradePair;
    private double currentTradeValue;

    public DecreaseEvent(){}

    public DecreaseEvent(String tradePair, double currentTradeValue) {
        this.tradePair = tradePair;
        this.currentTradeValue = currentTradeValue;
    }

    public String getTradePair() {
        return tradePair;
    }

    public void setTradePair(String tradePair) {
        this.tradePair = tradePair;
    }

    public double getCurrentTradeValue() {
        return currentTradeValue;
    }

    public void setCurrentTradeValue(double currentTradeValue) {
        this.currentTradeValue = currentTradeValue;
    }

    @Override
    public String toString() {
        return "DecreaseEvent{" +
                "tradePair='" + tradePair + '\'' +
                ", currentTradeValue=" + currentTradeValue +
                '}';
    }
}
