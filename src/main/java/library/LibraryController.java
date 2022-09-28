package library;

import java.util.Scanner;

public class LibraryController {

    private Library library =new Library();

    void doDecision() {
        menu();
        action(choose());
    }

    private void menu() {
        System.out.println("Wybierz dostępne opcje.");
        System.out.println("1.dodaj urzytkownika.");
        System.out.println("2. wyświetl urzytkowników");
    }

   private int choose() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

   private void action(int choice) {
        if (choice == 1) {
            User user = new User();
            library.addUser(user);
        } else if (choice == 2) {
            System.out.println(library);
        }
    }

}
