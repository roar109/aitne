package com.github.roar109.launcher.rest;

import retrofit2.Call;

public interface TickerExchange<T> {
    Call<T> ticker(String book);
}
