package com.github.roar109.launcher.data.dto;

public class Ticker {
    private String pair;
    private double porcentage;
    private double baseline_value;
    private int increase_or_decrease;
    private String exchange_alias;

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public double getPorcentage() {
        return porcentage;
    }

    public void setPorcentage(double porcentage) {
        this.porcentage = porcentage;
    }

    public double getBaseline_value() {
        return baseline_value;
    }

    public void setBaseline_value(double baseline_value) {
        this.baseline_value = baseline_value;
    }

    public int getIncrease_or_decrease() {
        return increase_or_decrease;
    }

    public void setIncrease_or_decrease(int increase_or_decrease) {
        this.increase_or_decrease = increase_or_decrease;
    }

    public String getExchange_alias() {
        return exchange_alias;
    }

    public void setExchange_alias(String exchange_alias) {
        this.exchange_alias = exchange_alias;
    }
}
