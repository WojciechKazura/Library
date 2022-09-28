package library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private UserRepository userRepository=new UserRepository();

    void addUser(User user) {
        userRepository.add(user);
    }

    @Override
    public String toString() {
        return "Library{" +
                "userArrayList=" + userRepository +
                '}';
    }
}
