package com.github.roar109.launcher.provider;

import com.github.roar109.launcher.rest.BinanceTicker;
import com.github.roar109.launcher.rest.BitsoTicker;
import com.github.roar109.launcher.rest.TickerExchange;
import com.github.roar109.launcher.rest.dto.BinancePriceTicker;
import com.github.roar109.launcher.rest.dto.BitsoTickerResponse;
import com.github.roar109.launcher.rest.dto.TickerResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.lang.reflect.Method;

public class ExchangeProvider {

    private final static ExchangeProvider INSTANCE = new ExchangeProvider();

    private ExchangeProvider(){}

    public static ExchangeProvider instance(){
        return INSTANCE;
    }

    public TickerResponse getAndExecuteExchange(final String exchangeAlias, String currency) throws Exception{

        if("BITSO".equals(exchangeAlias)){
            BitsoTicker exchange = getBitsoExchange();
            Call<BitsoTickerResponse> exchangeCall = exchange.ticker(currency);
            Response<BitsoTickerResponse> restResponse = exchangeCall.execute();

            if(restResponse.isSuccessful()){
                return new TickerResponse(Double.valueOf(restResponse.body().getPayload().getAsk()), currency);
            }else{
                throw new IllegalStateException(restResponse.errorBody().string());
            }
        }else if("BINANCE".equals(exchangeAlias)){
            BinanceTicker exchange =  getBinanceExchange();
            Call<BinancePriceTicker> exchangeCall = exchange.ticker(currency);
            Response<BinancePriceTicker> restResponse = exchangeCall.execute();

            if(restResponse.isSuccessful()){
                return new TickerResponse(restResponse.body().getPrice(), currency);
            }else{
                throw new IllegalStateException(restResponse.errorBody().string());
            }
        }

        return null;
    }

    public BitsoTicker getBitsoExchange(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.bitso.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BitsoTicker.class);
    }

    public BinanceTicker getBinanceExchange(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.binance.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BinanceTicker.class);
    }
}
