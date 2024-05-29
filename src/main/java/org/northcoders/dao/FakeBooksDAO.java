package org.northcoders.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.northcoders.model.Book;
import org.northcoders.model.Data;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FakeBooksDAO {

    private static final String Base_URL = "https://fakerapi.it/api/v1/books";
    public static Data getBooks(int quantity){

        try {
            HttpResponse<String> response = null;
            ObjectMapper mapper = new ObjectMapper();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(Base_URL + "?_quantity=" + quantity))
                    .GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            Data data1 = mapper.readValue(response.body(), Data.class);
            System.out.println(data1.data());
            return data1;

//            var book1 = mapper.readValue(data1.data(), Book.class);
//            System.out.println("Author is : " + book1.author());


        }catch (URISyntaxException | InterruptedException | IOException e){
            e.printStackTrace();
            return null;
        }
    }

}
