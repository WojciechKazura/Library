package library;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException() {
        super("Nie znaleziono  książki.");
    }


}
