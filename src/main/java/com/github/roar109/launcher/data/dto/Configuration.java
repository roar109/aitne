package com.github.roar109.launcher.data.dto;

public class Configuration {
    private Ticker[] tickers;
    private boolean eventsEnabled;

    public Ticker[] getTickers() {
        return tickers;
    }

    public void setTickers(Ticker[] tickers) {
        this.tickers = tickers;
    }

    public boolean isEventsEnabled() {
        return eventsEnabled;
    }

    public void setEventsEnabled(boolean eventsEnabled) {
        this.eventsEnabled = eventsEnabled;
    }
}
