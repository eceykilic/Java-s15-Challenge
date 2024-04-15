

import com.workintech.library.Library;
import com.workintech.library.book.Book;
import com.workintech.library.enums.Category;
import com.workintech.library.enums.Status;
import com.workintech.library.person.Author;
import com.workintech.library.person.Librarian;
import com.workintech.library.person.Person;
import com.workintech.library.person.Reader;

import java.util.*;

import static com.workintech.library.management.BookManagement.addNewBook;
import static com.workintech.library.management.BookManagement.removeBook;
import static com.workintech.library.management.ListingManagement.*;
import static com.workintech.library.management.UserManagement.createUser;
import static com.workintech.library.management.UserManagement.login;
import static com.workintech.library.management.BorrowingManagement.borrowBook;
import static com.workintech.library.management.BorrowingManagement.returnBook;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);
        Set<Reader> readers = new HashSet<>();
        Set<Librarian> librarians = new HashSet<>();

        // Varsayılan kütüphaneci ve okuyucu oluşturma
        Librarian defaultLibrarian = new Librarian("Kütüp", "Haneci", "kutup@ece.com", "123");
        librarians.add(defaultLibrarian);

        Reader defaultReader = new Reader("Oku", "Yucu", "okuyucu@ece.com", "321");
        readers.add(defaultReader);

        Library library = new Library(new LinkedList<>(), new HashSet<>());

        // Yeni bir kitap eklemek için
        Book newBook = library.newBook(1, new Author("Luke", "Skywalker"), "The Force Awakens: A Jedi's Journey", 39.99, Status.AVAILABLE, Category.SCIENCE_FICTION, 10);
        Book newBook2 = library.newBook(2, new Author("Rick", "Sanchez"), "Interdimensional Adventures: The Quest for Portal Gun", 19.99, Status.AVAILABLE, Category.SCIENCE_FICTION, 2);
        Book newBook3 = library.newBook(3, new Author("Din", "Grogu"), "The Adventures of a Young Jedi", 59.99, Status.AVAILABLE, Category.SCIENCE_FICTION, 5);
        Book newBook4 = library.newBook(4, new Author("Anakin", "Skywalker"), "Rise of the Chosen One: Anakin's Path to the Dark Side", 29.99, Status.AVAILABLE, Category.SCIENCE_FICTION, 6);
        Book newBook5 = library.newBook(5, new Author("Paul", "Atreides"), "Dune: Sands of Arrakis", 49.99, Status.AVAILABLE, Category.SCIENCE_FICTION, 2);
        Book newBook6 = library.newBook(6, new Author("Morty", "Smith"), "Morty's Misadventures: A Journey Across Dimensions", 19.99, Status.AVAILABLE, Category.MYSTERY, 1);
        Book newBook7 = library.newBook(7, new Author("J.K.", "Rowling"), "The Sorcerer's Stone: Harry's First Year at Hogwarts", 24.99, Status.AVAILABLE, Category.FANTASY, 8);
        Book newBook8 = library.newBook(8, new Author("J.K.", "Rowling"), "The Chamber of Secrets: The Secret of the Heir", 24.99, Status.AVAILABLE, Category.HORROR, 6);
        Book newBook9 = library.newBook(9, new Author("J.K.", "Rowling"), "The Prisoner of Azkaban: Sirius Black's Escape", 24.99, Status.AVAILABLE, Category.FANTASY, 7);
        Book newBook10 = library.newBook(10, new Author("Gru", "Gru"), "Minions Mayhem: Adventures of Gru and Minions", 14.99, Status.AVAILABLE, Category.COMEDY, 10);
        Book newBook11 = library.newBook(11, new Author("Margo", "Gru"), "Adventures of Margo: Gru's Eldest Daughter", 14.99, Status.AVAILABLE, Category.COMEDY, 5);
        Book newBook12 = library.newBook(12, new Author("Edith", "Gru"), "Edith's Pranks: Misadventures of Gru's Middle Daughter", 14.99, Status.AVAILABLE, Category.COMEDY, 6);
        Book newBook13 = library.newBook(13, new Author("Ece", "Yu"), "Ece's Most Precious Art Pieces & Their Histories", 100.99, Status.AVAILABLE, Category.ART, 13);
        Book newBook14 = library.newBook(14, new Author("Ece", "Kilic"), "How I Became A Developer", 34.99, Status.AVAILABLE, Category.DRAMA, 1);

        Person user = null;

        while (user == null) {
            System.out.println("Lütfen işlem yapmak için giriş yapın veya yeni bir hesap oluşturun.");
            System.out.println("1. Giriş yap");
            System.out.println("2. Yeni hesap oluştur");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    user = login(scanner, readers, librarians);
                    break;
                case 2:
                    createUser(scanner, readers);
                    break;
                case 3:
                    System.out.println("Kütüphanenin kapıları kapatılıyor. Hoşçakalın!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }

        while (true) {
            System.out.println("\n----**** Ece'nin Kütüphanesi ****----");
            showMenu(user);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (user instanceof Reader) {
                        borrowBook(scanner, library, (Reader) user);
                    } else if (user instanceof Librarian) {
                        addNewBook(scanner, library);
                    }
                    break;
                case 2:
                    if (user instanceof Reader) {
                        returnBook(scanner, library, (Reader) user);
                    } else if (user instanceof Librarian) {
                        showAllBooks(library);
                    }
                    break;
                case 3:
                    if (user instanceof Reader) {
                        showAllBooks(library);
                    } else if (user instanceof Librarian) {
                        removeBook(scanner, library);
                    }
                    break;
                case 4:
                    getBooksByCategory(library, scanner);
                    break;
                case 5:
                    getBooksbyAuthor(scanner, library);
                    break;
                case 6:
                    System.out.println("Kütüphanenin kapıları kapatılıyor. Hoşçakalın!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız!");
            }
        }

    }

    // Kullanıcı rolüne göre menüyü gösterir
    private static void showMenu(Person user) {
        if (user instanceof Reader) {
            System.out.println("1. Kitap ödünç al.");
            System.out.println("2. Kitap iade et.");
            System.out.println("3. Kütüphanedeki bütün kitapları göster.");
            System.out.println("4. Kategoriye göre kitapları listele.");
            System.out.println("5. Yazar ismine göre kitapları listele.");
            System.out.println("6. Çıkış");
            System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
        } else if (user instanceof Librarian) {
            System.out.println("1. Yeni kitap ekle.");
            System.out.println("2. Kütüphanedeki bütün kitapları göster.");
            System.out.println("3. Kütüphaneden kitap sil.");
            System.out.println("4. Kategoriye göre kitapları listele.");
            System.out.println("5. Yazar ismine göre kitapları listele.");
            System.out.println("6. Çıkış");
            System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
        } else {
            System.out.println("Geçersiz kullanıcı!");
        }
    }


}