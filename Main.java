import models.*;
import services.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        NotificationService notifier = new NotificationService();
        notifier.start();

        Book b1 = new Book("Effective Java", "Joshua Bloch");
        Book b2 = new Book("Clean Code", "Robert C. Martin");

        library.addBook(b1);
        library.addBook(b2);

        Member m1 = new Member("Alice");
        Member m2 = new Member("Bob");

        library.showBooks();
        library.borrowBook(m1, b1);
        library.borrowBook(m2, b1); // should trigger exception
        library.showBooks();

        library.returnBook(m1, b1);
        library.showBooks();
    }
}
