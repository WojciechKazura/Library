package library;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryController {

    private Library library = new Library();
    private boolean isDone = false;

   void start() {
        do {
            doDecision();
        }
        while (!isDone);
    }



    void startLibrary() {
        System.out.println("Witaj w bibiotece.");
        login();
        start();
    }

    private void login() {
        System.out.println("Aby z niej skożystać musisz posiadać aktywne konto.");
        System.out.println("czy masz już konto?");
        System.out.println("1.tak    2.nie");
        int decision =choose();
        if (decision == 1) {
            singIn();
        } else if (decision == 2) {
            User user = createUser();
            library.addUserToUserRepository(user);
        } else {
            System.out.println("Nieprawidłowy wybór. " + "Spróbuj ponownie");
            login();
        }
    }

    private User createUser() {
        System.out.println("Wprowadż email.");
        String email = readLine();
        System.out.println("Wprowadz hasło.");
        String password = readLine();
        System.out.println("Stworzono urzytkownika.");
        return new User(email, password);
    }

    private void doDecision() {
        chooseMenu();
        try{
            start(choose());
        }catch ( BookNotFoundException e){
            System.out.println(e.getMessage());
            chooseMenu();
        }
        start(choose());
    }

    void chooseMenu() {
        System.out.println("Wybierz dostępne opcje:");
        System.out.println("1.wyświetl urzytkowników.");
        System.out.println("2.dodaj książkę do bilioteki.");
        System.out.println("3.wyświetl listę książek.");
        System.out.println("4.wypożycz książkę.");
        System.out.println("5.oddaj książkę.");
        System.out.println("6.zakończ program.");
    }

    private int choose() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("nieprawidłowy wybór, spróbuj ponownie");
            return choose();
        }
    }

    void start(int choice) {
        if (choice == 1) {
            System.out.println(library.getUser());
        } else if (choice == 2) {
            Book book = createBook();
            library.addBookToBookRepository(book);
        } else if (choice == 3) {
            System.out.println(library.getBooks());
        } else if (choice == 4) {
            subMenuForBorrow();
        } else if (choice == 5) {
            subMenuForReturn();
        } else if (choice == 6) {
            System.out.println("zakończono");
            isDone = true;
        } else {
            System.out.println("Nieprawidłowy wybór, spróbój ponownie.");
            start(choose());
        }
    }

    Book createBook() {
        System.out.println("Wprowadź tytuł książki.");
        String title = readLine();
        System.out.println("Wprowadź autora książki.");
        String author = readLine();
        return new Book(title, author);
    }

    private void subMenuForBorrow() {
        System.out.println("Dostępne książki:");
        System.out.println(library.getBooks());
        System.out.println("Którą książke chcesz wypożyczyć?");
        System.out.println("wprowadz tytuł lub autora.");
        String bookOrAuthor = readLine();
        library.borrow(bookOrAuthor);
    }

    private void subMenuForReturn() {
        System.out.println("Wprowadź tytuł oddawanej książki.");
        String bookTitle = readLine();
        library.getBackBook(bookTitle);
    }

    private void singIn() {
        System.out.println("Zalogiuj się..");
        String user = chooseUser();
        String password = choosePassword();
        if(!library.singIn(user, password)){
            singIn();
        }
    }

    private String chooseUser() {
        System.out.println("Wprowadż nazwę urzykownika.");
        return readLine();
    }

    String choosePassword() {
        System.out.println("Wprowadz hasło.");
        return readLine();
    }

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
