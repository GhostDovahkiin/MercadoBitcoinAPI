package com.example.mercadobitcoinapi.models;

import java.util.List;

public class MercadoBitcoinCatalog {
    public List<Trades> trades;
    public DaySummary daysummary;

    public List<Trades> getTrades() {
        return trades;
    }
}
