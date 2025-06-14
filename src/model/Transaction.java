package model;

import java.time.LocalDate;

public class Transaction {
    private String transactionId;
    private String memberId;
    private String isbn;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String status;

    public Transaction(String transactionId, String memberId, String isbn, LocalDate borrowDate, LocalDate returnDate, String status) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.isbn = isbn;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public String getTransactionId() { return transactionId; }
    public String getMemberId() { return memberId; }
    public String getIsbn() { return isbn; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return transactionId + "," + memberId + "," + isbn + "," + borrowDate + "," + returnDate + "," + status;
    }
}
