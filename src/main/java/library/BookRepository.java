package library;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class BookRepository {

    abstract void saveBook(List<Book> bookList);
    abstract List<Book> getBooks();

    Book borrowBook(String bookOrAuthor) {
        List<Book> bookList = getBooks();
        for (Book b : bookList) {
            if (b.getTitle().equals(bookOrAuthor)) {
                System.out.println("Wypożyczono książkę " + b.getTitle());
                b.setBorrow(true);
                saveBook(bookList);
                return b;
            } else if (howManyBooksHaveTheSameAuthor(bookList, bookOrAuthor) > 1) {
                b.setBorrow(true);
                System.out.println("Wypożyczono książkę " + b.getTitle());
                saveBook(bookList);
                return b;
            }
        }
        throw new NoSuchElementException("Nie znaleziono autora lub w bibliotece jest więcej niz jedna książka jego autorstwa.");
    }

    void addBookToJson(Book book) {
        List<Book> bookList = getBooks();
        bookList.add(book);
        saveBook(bookList);
    }

    private int howManyBooksHaveTheSameAuthor(List<Book> bookList, String author) {
        int howManyBookHaveTheSameAuthor = 0;
        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                howManyBookHaveTheSameAuthor++;
            }
            return howManyBookHaveTheSameAuthor;
        }
        return howManyBookHaveTheSameAuthor;
    }

    Book giveBackBook(String bookTitle) {
        List<Book> bookList = getBooks();
        for (Book b : bookList) {
            if (b.getTitle().equals(bookTitle)) {
                b.setBorrow(false);
                System.out.println("Oddano książkę " + b.getTitle());
                saveBook(bookList);
                return b;
            }
        }
        throw  new BookNotFoundException();
    }


}
