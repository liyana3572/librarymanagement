package models;

import utils.BookNotAvailableException;

public class Book implements Borrowable {
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public void borrow() throws BookNotAvailableException {
        if (!isAvailable) throw new BookNotAvailableException(title + " is not available!");
        isAvailable = false;
    }

    @Override
    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isAvailable ? " (Available)" : " (Borrowed)");
    }
}
