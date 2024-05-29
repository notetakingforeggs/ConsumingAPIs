package org.northcoders.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FakeBooksDAO {

    private static final String Base_URL = "https://fakerapi.it/api/v1/books";
    public static void getBooks(){

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(Base_URL + "?_quantity=1"))
                    .GET().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }catch (URISyntaxException | InterruptedException | IOException e){
            e.getMessage();
        }
    }

}
