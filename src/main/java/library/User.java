package library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements Serializable {

    private String email;
    private String password;
    private List<Book> bookList = new ArrayList<>();


    User(String email, String password) {
    this.email=email;
    this.password=password;
    }

    User(){

    }


    //todo
    private void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj dane urzytkownika.");
        System.out.println("Wprowadź email.");
        email = scanner.nextLine();
        System.out.println("Wprowadź hasło");
        password = scanner.nextLine();
    }

    boolean checkFreePlace() {
        if (bookList.size() <4){
            return true;
        }else{
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    String userBorrowList() {
        if (!bookList.isEmpty()) {
            String text = " Urzytkownik wypożyczył: ";
            for (Book b : bookList) {
                text = text + " " + b;
            }
            return text;
        }
        return " Nie ma wypożyczonych książek.";
    }


    @Override
    public String toString() {
        return "Urzytkownik " + email + " hasło " + password + userBorrowList();
    }


}
