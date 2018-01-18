package com.github.roar109.launcher.rest.dto;

public class TickerResponse {
    private double price;
    private String currency;

    public TickerResponse(){}

    public TickerResponse(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
