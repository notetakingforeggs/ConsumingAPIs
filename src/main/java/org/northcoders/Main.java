package org.northcoders;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.northcoders.dao.FakeBooksDAO;
import org.northcoders.model.Book;
import org.northcoders.model.Data;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Book> books = FakeBooksDAO.getBooks(4).data();

        ObjectMapper mapper = new ObjectMapper();

        try {
            String objAsJSON = mapper.writeValueAsString(books.get(3));
            System.out.println(objAsJSON);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}