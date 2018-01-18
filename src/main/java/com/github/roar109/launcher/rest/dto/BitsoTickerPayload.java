package com.github.roar109.launcher.rest.dto;

public class BitsoTickerPayload {
    private String high;
    private String last;
    private String book;
    private String volume;
    private String vwap;
    private String low;
    private String ask;
    private String bid;

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getVwap() {
        return vwap;
    }

    public void setVwap(String vwap) {
        this.vwap = vwap;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "BitsoTickerPayload{" +
                "high='" + high + '\'' +
                ", last='" + last + '\'' +
                ", book='" + book + '\'' +
                ", volume='" + volume + '\'' +
                ", vwap='" + vwap + '\'' +
                ", low='" + low + '\'' +
                ", ask='" + ask + '\'' +
                ", bid='" + bid + '\'' +
                '}';
    }
}
