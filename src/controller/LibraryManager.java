package controller;

import model.Book;
import model.Member;
import model.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private final String BOOK_FILE = "data/books.csv";
    private final String MEMBER_FILE = "data/members.csv";
    private final String TRANSACTION_FILE = "data/transactions.csv";

    //================= BOOK CRUD ===================
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

    //================= MEMBER CRUD ===================
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MEMBER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                members.add(new Member(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (IOException e) {
            System.out.println("Error reading member data: " + e.getMessage());
        }
        return members;
    }

    public void addMember(Member member) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBER_FILE, true))) {
            writer.write(member.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error adding member: " + e.getMessage());
        }
    }

    //================= TRANSACTION CRUD ===================
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTION_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                transactions.add(new Transaction(
                        parts[0], parts[1], parts[2],
                        LocalDate.parse(parts[3], formatter),
                        LocalDate.parse(parts[4], formatter),
                        parts[5]
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading transactions: " + e.getMessage());
        }
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTION_FILE, true))) {
            writer.write(transaction.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error adding transaction: " + e.getMessage());
        }
    }

    //================= FINE CALCULATION ===================
    public long calculateFine(LocalDate dueDate, LocalDate actualReturnDate) {
        long daysLate = ChronoUnit.DAYS.between(dueDate, actualReturnDate);
        return (daysLate > 0) ? daysLate * 1000 : 0; // 1000 per hari keterlambatan
    }
}
