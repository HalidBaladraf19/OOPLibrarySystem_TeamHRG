package controller;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private final String BOOK_FILE = "data/books.csv";

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                books.add(new Book(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
            }
        } catch (IOException e) {
            System.out.println("Error reading book data: " + e.getMessage());
        }
        return books;
    }

    public void addBook(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE, true))) {
            writer.write(book.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }
}
