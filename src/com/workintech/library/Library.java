package com.workintech.library;

import com.workintech.library.book.Book;
import com.workintech.library.enums.Category;
import com.workintech.library.enums.Status;
import com.workintech.library.person.Author;
import com.workintech.library.person.Reader;

import java.util.*;

public class Library {
    private List<Book> books;
    private Set<Reader> readers;

    //constructor start
    public Library(List<Book> books, Set<Reader> readers) {
        this.books = new LinkedList<>(books); // Liste kopyasını oluştur
        this.readers = new HashSet<>(readers); // Küme kopyasını oluştur
    }
    //constructor end

    //getter setter start

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void setReaders(Set<Reader> readers) {
        this.readers = readers;
    }

    //getter setter end

    public Book newBook(int book_ID, Author author, String title, double price, Status status, Category category, int stock) {
        Book book = new Book(book_ID, author, title, price, status, category, stock);
        books.add(book);
        return book; // Oluşturulan kitap nesnesini döndür
    }

    public List<Book> showBooks(){
        if (books == null || books.isEmpty()){
            System.out.println("Kütüphanede kitap bulunmamaktadır!");
        } else {
            for(Book book: books){
                System.out.println(book.display());
            }
        }

        return books;
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBook_ID() == bookId) {
                return book;
            }
        }
        return null; // Kitap bulunamadıysa null döndür
    }

    public List<Book> getBooksByCategory(Category category) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory() == category) {
                result.add(book);
            }
        }
        return result;
    }

    //yazar ismine göre kitaplar bulunur.
    public List<Book> getBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getFirstName().equals(authorName) || book.getAuthor().getLastName().equals(authorName)) {
                result.add(book);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Belirtilen yazarın kitabı bulunamadı.");
        }
        return result;
    }

    //yazar ismine göre kitaplar basılır.
    public void displayBooksByAuthor(String author) {
        List<Book> booksByAuthor = getBooksByAuthor(author);
        for (Book book : booksByAuthor) {
            System.out.println(book.display());
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }
}

