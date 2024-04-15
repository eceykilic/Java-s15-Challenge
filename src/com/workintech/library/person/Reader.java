package com.workintech.library.person;

import com.workintech.library.book.Book;
import com.workintech.library.enums.UserRole;

import java.util.LinkedList;
import java.util.List;

public class Reader extends Person {
    private String email;
    private String password;
    private List<Book> borrowedBooks;

    private UserRole role;

    //constructors start

    public Reader(String firstName, String lastName, String email, String password) {
        super(firstName, lastName);
        this.email = email;
        this.password = password;
        this.borrowedBooks = new LinkedList<>();
        this.role = UserRole.READER;
    }
    //constructors end

    //getter setter start

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    //getter setter end

    public List<Book> getBorrowedBooks() {
        if (borrowedBooks == null) {
            borrowedBooks = new LinkedList<>();
        }
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
