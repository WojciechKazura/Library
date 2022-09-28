package library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<User> userArrayList = new ArrayList<>();

    void addUser(User user) {
        userArrayList.add(user);
    }

    @Override
    public String toString() {
        return "Library{" +
                "userArrayList=" + userArrayList +
                '}';
    }
}
