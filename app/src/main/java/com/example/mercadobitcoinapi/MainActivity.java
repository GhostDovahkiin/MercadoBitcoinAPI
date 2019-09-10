package com.example.mercadobitcoinapi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mercadobitcoinapi.models.MercadoBitcoinCatalog;
import com.example.mercadobitcoinapi.models.Trades;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Tag;

public class MainActivity extends AppCompatActivity {
    String Tag = "Summary: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MercadoBitcoinService.URLBASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MercadoBitcoinService service = retrofit.create(MercadoBitcoinService.class);
        Call<List<Trades>> requestTrades = service.listTrades();

        requestTrades.enqueue(new Callback<List<Trades>>() {
            @Override
            public void onResponse(Call<List<Trades>> call, Response<List<Trades>> response) {
                if (!response.isSuccessful()) {
                    Log.e(Tag, "Err: " + response.code());
                } else {
                    List<Trades> transacoes = response.body();

                    for (Trades t : transacoes) {
                        Log.i(Tag, String.format("\nTransacao ID: %s \nTipo: %s \nValor da moeda: %f \nQuantidade: %f", t.tid, t.type, t.price, t.amount));
                    }
                    Log.i(Tag, "-------------------------------------------------------------");
                }
            }

            @Override
            public void onFailure(Call<List<Trades>> call, Throwable t) {

            }
        });
    }
}