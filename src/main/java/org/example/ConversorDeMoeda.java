package org.example;

import com.google.gson.Gson;

public class ConversorDeMoeda {
    private Gson gson = new Gson();
    public double converter(String json, String moedaDestino, double valor) {
        ExchangeResponse resposta = gson.fromJson(json, ExchangeResponse.class);
        Double taxa = resposta.getConversionRates().get(moedaDestino);
        return valor * taxa;
        }
}
