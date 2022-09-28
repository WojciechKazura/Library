package library;

public class LibraryDemo {

    public static void main(String[] args) {
        LibraryController controller = new LibraryController();
        boolean isDone=false;
        do {
            controller.doDecision();
        }
        while (!isDone);

    }

}
