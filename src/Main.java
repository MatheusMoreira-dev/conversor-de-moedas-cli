import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String key = "b052d0d2625f2771aa54860f";
        String url = "https://v6.exchangerate-api.com/v6/%s/latest/USD".formatted(key);

        //Cliente
        HttpClient client = HttpClient.newHttpClient();

        //Requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();

        //Resposta
        HttpResponse<String> response = client.
                send(request, HttpResponse.BodyHandlers.ofString());
        //Resposta Json
        String json = response.body();
        Gson gson = new Gson();

        System.out.println(json);
    }
}
