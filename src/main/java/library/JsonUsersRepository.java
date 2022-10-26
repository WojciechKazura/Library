package library;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUsersRepository extends UsersRepository {

    private ObjectMapper objectMapper = new ObjectMapper();
    private File file = new File("JsonUsersList.json");


    void save(List<User> userList) {
        try {
            objectMapper.writeValue(file, userList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List getUsers() {
        try {
            //return objectMapper.readValue(file, List.class); // Nie działa bo nie dostarczamy typu User i biblioteka nie wie jakie obiekty ma stworzyć do tej listy - na bazie jakiej klasy
            // return objectMapper.readValue(file, List<User>.class);
            // As array (then convert to a list)
//            User[] users = objectMapper.readValue(file, User[].class); // dostaniemy tablice ktora trzeba będzie wrzucić do listy
// With TypeReference
            // List<User> users2 = objectMapper.readValue(file, new TypeReference<List<User>>(){});
// with TypeFactory
            List<User> users3 = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
            return users3;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
