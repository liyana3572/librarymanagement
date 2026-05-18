package models;

import utils.BookNotAvailableException;

public interface Borrowable {
    void borrow() throws BookNotAvailableException;
    void returnBook();
}
