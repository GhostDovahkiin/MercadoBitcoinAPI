package com.example.mercadobitcoinapi;
import com.example.mercadobitcoinapi.models.MercadoBitcoinCatalog;
import com.example.mercadobitcoinapi.models.Trades;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MercadoBitcoinService {

    String URLBASE = "https://www.mercadobitcoin.net/api/BTC/trades/";

    @GET("1567123200")
    Call<List<Trades>> listTrades();


}
