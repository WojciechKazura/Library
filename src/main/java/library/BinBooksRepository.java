package library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinBooksRepository {

    List<Book> addBook(Book book) {
        List<Book> bookList = getBook();
        System.out.println("Zapisuje książkę");
        bookList.add(book);
        saveBook(bookList);
        return bookList;
    }

    void saveBook(List<Book> bookList) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Books.bin"));
            objectOutputStream.writeObject(bookList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    List<Book> getBook() {
        try {
            ObjectInputStream objectINputStream = new ObjectInputStream(new FileInputStream("Books.bin"));
            List<Book> bookList = (List<Book>) objectINputStream.readObject();
            objectINputStream.close();
            return bookList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}


