package com.github.roar109.launcher.rest.dto;

import java.math.BigDecimal;

public class HuobiTickerPayload {
    private BigDecimal[] ask;
    private BigDecimal[] bid;
    private BigDecimal low;
    private BigDecimal high;

    public BigDecimal[] getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal[] ask) {
        this.ask = ask;
    }

    public BigDecimal[] getBid() {
        return bid;
    }

    public void setBid(BigDecimal[] bid) {
        this.bid = bid;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }
}
