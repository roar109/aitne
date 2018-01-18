package com.github.roar109.launcher.rest;

import com.github.roar109.launcher.rest.dto.BinancePriceTicker;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BinanceTicker{

    @GET("api/v3/ticker/price")
    Call<BinancePriceTicker> ticker(@Query("symbol") String symbol);
}
