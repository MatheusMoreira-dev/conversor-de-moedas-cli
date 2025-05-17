package br.com.conversor.api;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    private String key;
    private String baseCurrency;
    private String targetCurrency;
    private String amount;
    private String url;
    private HttpResponse<String> response;

    public Request(String key, String baseCurrency, String targetCurrency, String amount) throws IOException, InterruptedException {
        this.key = key;
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.url = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%s".formatted(this.key,this.baseCurrency,this.targetCurrency,this.amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url)).build();
        this.response = client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public String getJson(){
        return response.body();
    }

    public Conversor getconversion(){
        return new Gson().fromJson(response.body(),Conversor.class);
    }
}