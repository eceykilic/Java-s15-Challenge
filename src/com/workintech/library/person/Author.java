package com.workintech.library.person;

import com.workintech.library.book.Book;

import java.util.List;

public class Author extends Person {

    private List<Book> books;

    //constructors start
    public Author(String firstName, String lastName) {
        super(firstName, lastName);
    }
    //constructors end

    //getter setter start

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //getter setter end


    //bu method yazarın adını ve soyadını birleştirerek döndürür
    public String displayAuthorName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        return getFirstName() + ' ' + getLastName();
    }

}
