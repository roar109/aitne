package com.github.roar109.launcher.types;

public enum ParameterNames {

    TRADING_PAIR_CURRENCIES("trading_pair_currencies"),
    BASELINE_CURRENCY_VALUE("baseline_curency_value"),
    TOLERANCE_PERCENTAGE("tolerance_percentage"),
    TICKER_TYPE("type"),
    EXCHANGE_ALIAS("exchange_alias");

    private String name;

    ParameterNames(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
