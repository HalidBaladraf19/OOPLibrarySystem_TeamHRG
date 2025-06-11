import controller.LibraryManager;
import model.Book;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        // Contoh menambahkan buku baru
        Book newBook = new Book("978-602-73156-1-0", "Pemrograman Java Dasar", "Agus Salim", 5);
        manager.addBook(newBook);

        // Menampilkan daftar buku
        manager.getAllBooks().forEach(System.out::println);
    }
}
