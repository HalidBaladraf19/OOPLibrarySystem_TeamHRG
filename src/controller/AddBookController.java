package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Book;

public class AddBookController {
    @FXML private TextField isbnField;
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField quantityField;

    private LibraryManager manager = new LibraryManager();

    @FXML
    public void handleAddBook() {
        try {
            Book book = new Book(
                    isbnField.getText(),
                    titleField.getText(),
                    authorField.getText(),
                    Integer.parseInt(quantityField.getText())
            );
            manager.addBook(book);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sukses");
            alert.setHeaderText(null);
            alert.setContentText("Buku berhasil ditambahkan!");
            alert.showAndWait();

            isbnField.clear(); titleField.clear(); authorField.clear(); quantityField.clear();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Format jumlah tidak valid!");
            alert.showAndWait();
        }
    }
}
