package library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinUserRepository extends UsersRepository {


    void save(List<User> userList) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Users.bin"));
            objectOutputStream.writeObject(userList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    List<User> getUsers() {
        try {
            ObjectInputStream objectINputStream = new ObjectInputStream(new FileInputStream("Users.bin"));
            List<User> listUsers = (List<User>) objectINputStream.readObject();
            objectINputStream.close();
            return listUsers;
        } catch (IOException | ClassNotFoundException e) {
            //   e.printStackTrace();
            return new ArrayList<>();
        }
    }

}