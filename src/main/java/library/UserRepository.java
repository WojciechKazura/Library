package library;

import java.io.*;

public class UserRepository {

    void add(User user){
        System.out.println("Zapisuje urzytkownika");
        try {
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream("Users.bin"));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    User getUser(){
        try {
            ObjectInputStream objectINputStream= new ObjectInputStream(new FileInputStream("Users.bin"));
            User user= (User) objectINputStream.readObject();
            objectINputStream.close();
            return user;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }



}
