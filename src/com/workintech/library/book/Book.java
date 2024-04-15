package com.workintech.library.book;

import com.workintech.library.enums.Category;
import com.workintech.library.enums.Status;
import com.workintech.library.person.Author;
import com.workintech.library.person.Person;
import com.workintech.library.person.Reader;

import java.util.Objects;

public class Book implements Available{
    private int book_ID;
    private Author author;
    private String title;
    private double price;
    private Status status;
    private Category category;

    private int stock;


    //constructors start

    public Book(int book_ID, Author author, String title, double price, Status status, Category category, int stock) {
        this.book_ID = book_ID;
        this.author = author;
        this.title = title;
        this.price = price;
        this.status = status;
        this.category = category;
        this.stock = stock;
    }

    //constructors end

    //getter setter start


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getBook_ID() {
        return book_ID;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBook_ID(int book_ID) {
        this.book_ID = book_ID;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //getter setter end

    //temsili kimlik. kitabın kimliği, başlığı, yazarı, kategorisi ve sahibi hakkında bilgi içerir.
    public String display() {
        return "Book ID: " + book_ID +
                ", Title: " + title +
                ", Author: " + author.displayAuthorName()+
                ", Category: " + category +
                ", Stock: " + stock +
                ", Durum: " + (stock > 0 ? "Mevcut" : "Tükendi");
    }

    //kitabın durumu "uygun" ise, kitap mevcuttur
    @Override
    public boolean isAvailable() {
        return status == Status.AVAILABLE && stock > 0;
    }

    // Ödünç almak için okuyucunun maksimum kitap limitine ulaşmamış olması ve kitabın mevcut olması gerekir.
    @Override
    public boolean canBorrow(Reader reader) {
        return reader.getBorrowedBooks().size() < 5 && isAvailable();
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_ID +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book books)) return false;
        return book_ID == books.book_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_ID);
    }


}
