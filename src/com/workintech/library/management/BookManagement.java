package com.workintech.library.management;

import com.workintech.library.Library;
import com.workintech.library.book.Book;
import com.workintech.library.enums.Category;
import com.workintech.library.enums.Status;
import com.workintech.library.person.Author;

import java.util.Scanner;

public class BookManagement {
    //Kütüphane simülasyonuna yeni kitap ekler.
    public static void addNewBook(Scanner scanner, Library library) {
        System.out.print("Kitap ID'si giriniz: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Yazarın adını giriniz: ");
        String firstName = scanner.nextLine();

        System.out.print("Yazarın soyadını giriniz: ");
        String lastName = scanner.nextLine();

        System.out.print("Kitap kategorisini giriniz (NOVEL, MYSTERY, SCIENCE_FICTION, vb.): ");
        String categoryName = scanner.nextLine();
        Category category = Category.valueOf(categoryName.toUpperCase());

        System.out.print("Kitabın adını giriniz: ");
        String title = scanner.nextLine();

        System.out.print("Kitabın fiyatını giriniz: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Kitabın stok miktarını giriniz: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Author author = new Author(firstName, lastName);
        Book newBook = new Book(bookId, author, title, price, Status.AVAILABLE, category, stock);

        if (library.getBooks().contains(newBook)) {
            System.out.println("Bu kitap zaten eklenmiş!");
        } else {
            library.newBook(bookId, author, title, price, Status.AVAILABLE, category, stock); // stock parametresi eklendi
            System.out.println("Kitap başarıyla eklendi!");
        }
    }

    // Kütüphaneden kitap silme işlemi yapar.
    public static void removeBook(Scanner scanner, Library library) {
        System.out.println("Silmek istediğiniz kitabın ID'sini giriniz:");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book bookToRemove = null;
        for (Book book : library.getBooks()) {
            if (book.getBook_ID() == bookId) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            library.getBooks().remove(bookToRemove); // Kitabı kütüphaneden sil
            System.out.println("Kitap başarıyla silindi!");
        } else {
            System.out.println("Kitap bulunamadı!");
        }
    }

    // Kitap fiyatını güncelleme
    public static void updateBookPrice(Scanner scanner, Library library) {
        System.out.println("Güncellemek istediğiniz kitabın ID'si: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book bookToUpdate = library.findBookById(bookId);
        if (bookToUpdate != null) {
            System.out.println("Mevcut fiyat: " + bookToUpdate.getPrice());
            System.out.println("Yeni fiyatı girin: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();

            if (newPrice == bookToUpdate.getPrice()) {
                System.out.println("Girilen fiyat mevcut fiyatla aynı. Herhangi bir güncelleme yapılmadı.");
            } else {
                bookToUpdate.setPrice(newPrice);
                System.out.println("Kitap fiyatı başarıyla güncellendi!");
            }
        } else {
            System.out.println("Belirtilen ID'ye sahip bir kitap bulunamadı.");
        }
    }



}
