package library;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonBookRepository extends BookRepository{
    private ObjectMapper objectMapper = new ObjectMapper();
    private File file = new File("JsonBookList.json");



    void saveBook(List<Book> bookList) {
        try {
            objectMapper.writeValue(file, bookList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    List<Book> getBooks() {
        try {
            List<Book> bookList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));
            return bookList;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }



}
