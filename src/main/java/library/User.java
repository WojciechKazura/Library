package library;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {

    private String email;
    private String password;

    User(){
        createUser();
    }
//todo
    void createUser(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Podaj dane urzytkownika.");
        System.out.println("Wprowadź email.");
        email= scanner.nextLine();
        System.out.println("Wprowadź hasło");
        password=scanner.nextLine();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



}
