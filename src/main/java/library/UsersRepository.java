package library;

import java.util.List;

public abstract class UsersRepository {


    abstract void save(List<User> userList);

    abstract List<User> getUsers();

    void addUser(User user) {
        List<User> userList = getUsers();
        if (isFreeUserName(user.getEmail())) {
            System.out.println("Zapisuje urzytkownika");
            userList.add(user);
            save(userList);
        } else {
            System.out.println("Istnieje już urzytkownik o podanym mailu.");
        }
    }

    boolean isFreeUserName(String userMail) {
        List<User> userList = getUsers();
        for (User u : userList) {
            if (u.getEmail().equals(userMail)) {
                return false;
            }
        }
        return true;
    }

    void giveUserBorrowBook(String email, Book book) {
        List<User> userList = getUsers();
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                if (u.getBookList().size() < 4) {
                    u.getBookList().add(book);
                    System.out.println("Dodano książkę do urzytkownika");
                    save(userList);
                    break;
                } else {
                    System.out.println("przekroczono limit.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            } else {
                System.out.println("Nie dodadano książki!!!!!!!!!!!!!!!!!! Brak urzytkownika, szukam dalej.");
            }
        }
    }

    void takeAwayBook(String email, Book book) {
        List<User> userList = getUsers();
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                u.getBookList().remove(book);
                System.out.println("Urzytkownik " + u.getEmail() + " oddał książkę " + book.getTitle() + "!");
                save(userList);
                break;
            }
        }
    }

}
