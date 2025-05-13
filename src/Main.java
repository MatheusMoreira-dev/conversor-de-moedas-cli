import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "";

        //Cliente
        HttpClient client = HttpClient.newHttpClient();

        //Requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();

        //Resposta
        HttpResponse<String> response = client.
                send(request, HttpResponse.BodyHandlers.ofString());
    }
}
