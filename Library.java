package services;

import models.*;
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private Map<Member, List<Book>> borrowedBooks = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(Member member, Book book) {
        try {
            book.borrow();
            borrowedBooks.computeIfAbsent(member, k -> new ArrayList<>()).add(book);
            System.out.println(member.getName() + " borrowed " + book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(Member member, Book book) {
        if (borrowedBooks.containsKey(member) && borrowedBooks.get(member).contains(book)) {
            book.returnBook();
            borrowedBooks.get(member).remove(book);
            System.out.println(member.getName() + " returned " + book);
        } else {
            System.out.println(member.getName() + " did not borrow " + book);
        }
    }

    public void showBooks() {
        books.forEach(System.out::println);
    }
}
