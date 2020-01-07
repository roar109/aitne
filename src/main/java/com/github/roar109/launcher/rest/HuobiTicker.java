package com.github.roar109.launcher.rest;

import com.github.roar109.launcher.rest.dto.HuobiTickerResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HuobiTicker {
    @GET("market/detail/merged")
    Call<HuobiTickerResponse> ticker(@Query("symbol") String book);
}
