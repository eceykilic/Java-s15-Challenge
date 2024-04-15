package com.workintech.library.management;

import com.workintech.library.enums.UserRole;
import com.workintech.library.person.Librarian;
import com.workintech.library.person.Person;
import com.workintech.library.person.Reader;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserManagement {
    private Set<Reader> readers;
    private Set<Librarian> librarians;

    //constructor
    public UserManagement() {
        this.readers = new HashSet<>();
        this.librarians = new HashSet<>();
    }


    public void addReader(String firstName, String lastName, String email, String password) {
        readers.add(new Reader(firstName, lastName, email, password));
    }

    public void addLibrarian(String email, String password) {
        librarians.add(new Librarian(email, password));
    }

    public static Person login(Scanner scanner, Set<Reader> readers, Set<Librarian> librarians) {
        System.out.println("Lütfen e-posta ve şifrenizi girin.");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (Reader reader : readers) {
            if (reader.getEmail().equals(email) && reader.getPassword().equals(password)) {
                return reader;
            }
        }

        for (Librarian librarian : librarians) {
            if (librarian.getEmail().equals(email) && librarian.getPassword().equals(password)) {
                return librarian;
            }
        }

        System.out.println("Hatalı giriş! Tekrar deneyin.");
        return null;
    }

    public static void createUser(Scanner scanner, Set<Reader> readers) {
        System.out.println("Lütfen hesap bilgilerinizi girin.");
        System.out.print("Adınız: ");
        String firstName = scanner.nextLine();
        System.out.print("Soyadınız: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println("Rolünüzü belirtin (READER veya LIBRARIAN): ");
        String roleStr = scanner.nextLine().toUpperCase();
        UserRole role = UserRole.valueOf(roleStr);

        switch (role) {
            case READER:
                Reader newReader = new Reader(firstName, lastName, email, password);
                readers.add(newReader);
                System.out.println("Okuyucu hesabı başarıyla oluşturuldu.");
                break;
            case LIBRARIAN:
                System.out.println("Şu anda sadece okuyucu hesapları oluşturulabilir.");
                break;
            default:
                System.out.println("Geçersiz rol!");
        }
    }
}
