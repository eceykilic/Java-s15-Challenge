package com.workintech.library.management;

import com.workintech.library.Library;
import com.workintech.library.book.Book;
import com.workintech.library.enums.Category;

import java.util.*;

public class ListingManagement {
    //Kütüphanede varolan bütün kitapları gösterir.
    public static void showAllBooks(Library library) {
        if(library != null) {
            System.out.println("----**** TÜM KİTAPLAR ****----");
            List<Book> allBooks = library.getBooks();
            Collections.sort(allBooks, Comparator.comparing(Book::getBook_ID)); // Sort books by ID
            for (Book book : allBooks) {
                System.out.println("Book ID: " + book.getBook_ID() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Category: " + book.getCategory() + ", Stock: " + book.getStock() + ", Durum: " + book.getStatus());
            }
        } else {
            System.out.println("Kütüphane boş veya mevcut değil!");
        }
    }


    //Kitap türüne göre filtreleme yapar.

    public static Map<Category, List<Book>> getBooksByCategory(Library library, Scanner scanner) {
        Map<Category, List<Book>> booksByCategory = new HashMap<>();

        System.out.println("Lütfen bir kategori seçin (NOVEL, ART, COMEDY...): ");
        String categoryInput = scanner.nextLine().toUpperCase(); // Kullanıcının girdisini büyük harfe dönüştür

        try {
            Category category = Category.valueOf(categoryInput);
            List<Book> allBooks = library.getBooksByCategory(category);
            for (Book book : allBooks) {
                if (book.getCategory() == category) {
                    if (!booksByCategory.containsKey(category)) {
                        booksByCategory.put(category, new ArrayList<>());
                    }
                    booksByCategory.get(category).add(book);
                }
            }

            // Map boş ise belirtilen kategoride kitap bulunamadığını belirt
            if (booksByCategory.isEmpty()) {
                System.out.println("Belirtilen kategoride kitap bulunamadı.");
            } else {
                // Map dolu ise bulunan kitapları listele
                for (Map.Entry<Category, List<Book>> entry : booksByCategory.entrySet()) {
                    System.out.println("Category: " + entry.getKey());
                    for (Book book : entry.getValue()) {
                        System.out.println("Book ID: " + book.getBook_ID() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                                ", Category: " + book.getCategory() + ", Stock: " + book.getStock() + ", Durum: " + book.getStatus()) ;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Geçersiz kategori girdisi!");
        }

        return booksByCategory;
    }

    //Yazar ismine göre filtreleme yapar.
    public static void getBooksbyAuthor(Scanner scanner,Library library){
        System.out.println("Yazar ismi giriniz:");
        String author = scanner.nextLine();
        library.displayBooksByAuthor(author);

    }
}
