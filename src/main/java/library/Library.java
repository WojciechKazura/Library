package library;

import java.util.List;

public class Library {

    // private BinUserRepository userRepository = new BinUserRepository();
    // private BinBooksRepository booksRepository = new BinBooksRepository();
    private UsersRepository usersRepository = new JsonUsersRepository();
    private BookRepository bookRepository = new JsonBookRepository();

    private User loggedUser;

    void addBookToBookRepository(Book book) {
        //booksRepository.addBook(book);
        bookRepository.addBookToJson(book);
    }

    void addUserToUserRepository(User user) {
        usersRepository.addUser(user);
    }

    boolean singIn(String user, String password) {
        loggedUser = singInCheck(user, password);
        if (loggedUser == null) {
            System.out.println("Nie udało sie zalogować");
            return false;
        } else {
            return true;
        }
    }

    void borrow(String bookOrAuthor) {
        if (loggedUser.checkFreePlace()) {
            //Book book = booksRepository.borrowBook(bookOrAuthor);//możliwy null
            Book book = bookRepository.borrowBook(bookOrAuthor);
            if (book.getTitle() != null) {
                usersRepository.giveUserBorrowBook(loggedUser.getEmail(), book);
            } else {
                System.out.println("Niepoprawna nazwa książki.");
            }
        } else {
            System.out.println("Limit przekroczony.");
        }
    }

    void getBackBook(String bookTitle) {
        //Book book = booksRepository.giveBackBook(bookTitle);//możliwy null
        Book book = bookRepository.giveBackBook(bookTitle);
        usersRepository.takeAwayBook(loggedUser.getEmail(), book);
    }

    User singInCheck(String userName, String password) {
        List<User> userList = usersRepository.getUsers();
        for (User user : userList) {
            if (user.getEmail().equals(userName) && user.getPassword().equals(password)) {
                return user;
            } else {
                System.out.println("Nazwa urzytkownika lub hasło niepoprawne. Spróbuj ponownie");
            }
        }
        return null;
    }

    boolean checkUserIsEgsist(String userName, String password) {
        List<User> userList = usersRepository.getUsers();
        for (User user : userList) {
            if (user.getEmail().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    List<Book> getBooks() {
        //return booksRepository.getBook();
        return bookRepository.getBooks();
    }

    List<User> getUser() {
        return usersRepository.getUsers();
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
