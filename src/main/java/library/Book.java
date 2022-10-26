package library;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {

    private String title;
    private String author;
    private boolean isBorrow;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        isBorrow = false;
    }

    Book() {

    }

    private void createBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź tytuł książki");
        title = scanner.nextLine();
        System.out.println("Wprowadź autora");
        author = scanner.nextLine();
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Tytuł książki: " + title + " autor " + author + " " + isBorrow;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrow() {
        return isBorrow;
    }
}
