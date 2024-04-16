package com.workintech.library.management;

import com.workintech.library.Library;
import com.workintech.library.book.Book;
import com.workintech.library.person.Reader;

import java.util.Scanner;

public class BorrowingManagement {

    //Kütüphane simülasyonundan kitap ödünç almaya yarar.
    public static void borrowBook(Scanner scanner, Library library, Reader reader) {
        System.out.print("Ödünç almak istediğiniz kitabın ID'sini girin: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book book = library.findBookById(bookId);
        if (book == null) {
            System.out.println("Kitap bulunamadı!");
            return;
        }

        if (reader.getBorrowedBooks().size() >= 5) {
            System.out.println("Maksimum ödünç kitap sayısına ulaştınız!");
            return;
        }

        if (book.canBorrow(reader)) {
            reader.getBorrowedBooks().add(book);
            book.setStock(book.getStock() - 1);
            reader.setTotalAmountOwed(reader.getTotalAmountOwed() + book.getPrice());
            System.out.println("Kitap ödünç alındı: " + book.getTitle());
            System.out.println("Toplam borcunuz: " + reader.getTotalAmountOwed());
        } else {
            System.out.println("Kitap ödünç alınamıyor: " + book.getTitle());
        }
    }



    //Ödünç alınan kitabın iade edilmesini sağlar.

    public static void returnBook(Scanner scanner, Library library, Reader reader) {
        System.out.print("İade etmek istediğiniz kitabın ID'sini girin: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book book = library.findBookById(bookId);
        if (book == null) {
            System.out.println("Kitap bulunamadı!");
            return;
        }

        if (reader.getBorrowedBooks().contains(book)) {
            reader.getBorrowedBooks().remove(book);
            book.setStock(book.getStock() + 1);
            reader.setTotalAmountOwed(reader.getTotalAmountOwed() - book.getPrice()); // Toplam borçtan düş
            System.out.println("Kitap iade edildi: " + book.getTitle());
            System.out.println("İade edilen tutar: " + book.getPrice());
            System.out.println("Toplam borcunuz: " + reader.getTotalAmountOwed()); // Toplam borcu göster
        } else {
            System.out.println("Bu kitap zaten ödünç alınmamış: " + book.getTitle());
        }
    }


}
