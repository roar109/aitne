package com.github.roar109.launcher.rest;

import com.github.roar109.launcher.rest.dto.BitsoTickerResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BitsoTicker{
    @GET("v3/ticker")
    Call<BitsoTickerResponse> ticker(@Query("book") String book);
}
