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

    private double totalAmountOwed;
    private double totalRefundable;

    //constructors start

    public Reader(String firstName, String lastName, String email, String password) {
        super(firstName, lastName);
        this.email = email;
        this.password = password;
        this.borrowedBooks = new LinkedList<>();
        this.role = UserRole.READER;
        this.totalAmountOwed = 0.0;
        this.totalRefundable = 0.0;
    }

    //constructors end

    //getter setter start

    public double getTotalAmountOwed() {
        return totalAmountOwed;
    }

    public void setTotalAmountOwed(double totalAmountOwed) {
        this.totalAmountOwed = totalAmountOwed;
    }

    public double getTotalRefundable() {
        return totalRefundable;
    }

    public void setTotalRefundable(double totalRefundable) {
        this.totalRefundable = totalRefundable;
    }
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

    //null olmayacak şekilde başlattık çünkü NullPointerException almak istemeyiz.
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
