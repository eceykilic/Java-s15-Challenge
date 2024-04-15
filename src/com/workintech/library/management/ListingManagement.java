package com.workintech.library.management;

import com.workintech.library.Library;
import com.workintech.library.book.Book;
import com.workintech.library.enums.Category;

import java.util.List;
import java.util.Scanner;

public class ListingManagement {
    //Kütüphanede varolan bütün kitapları gösterir.
    public static void showAllBooks(Library library) {
        if(library != null) {
            System.out.println("---- KİTAPLAR ----");
            library.showBooks();
        } else {
            System.out.println("Kütüphane boş veya mevcut değil!");
        }
    }


    //Kitap türüne göre filtreleme yapar.

    public static void getBooksbyCategory(Scanner scanner, Library library) {
        System.out.println("Kitap kategorisini giriniz(JOURNALS, STUDYBOOKS, MAGAZINES):");
        String categoryInput = scanner.nextLine().toUpperCase(); // Kullanıcının girdisini büyük harfe dönüştür

        try {
            Category category = Category.valueOf(categoryInput);
            library.displayBooksByCategory(category);
        } catch (IllegalArgumentException e) {
            System.out.println("Bu kategoride kitap bulunamadı!");
        }
    }

    //Yazar ismine göre filtreleme yapar.
    public static void getBooksbyAuthor(Scanner scanner,Library library){
        System.out.println("Yazar ismi giriniz:");
        String author = scanner.nextLine();
        library.displayBooksByAuthor(author);

    }
}
