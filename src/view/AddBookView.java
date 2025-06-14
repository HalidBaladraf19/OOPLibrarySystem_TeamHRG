package view;

import controller.LibraryManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Book;

public class AddBookView {

    public static void display(LibraryManager manager) {
        Stage window = new Stage();
        window.setTitle("Tambah Buku Baru");

        TextField isbnField = new TextField();
        isbnField.setPromptText("ISBN");

        TextField titleField = new TextField();
        titleField.setPromptText("Judul Buku");

        TextField authorField = new TextField();
        authorField.setPromptText("Penulis");

        TextField quantityField = new TextField();
        quantityField.setPromptText("Jumlah");

        Button submitButton = new Button("Tambah Buku");
        submitButton.setOnAction(e -> {
            try {
                Book book = new Book(
                        isbnField.getText(),
                        titleField.getText(),
                        authorField.getText(),
                        Integer.parseInt(quantityField.getText())
                );
                manager.addBook(book);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sukses");
                alert.setHeaderText(null);
                alert.setContentText("Buku berhasil ditambahkan!");
                alert.showAndWait();

                isbnField.clear();
                titleField.clear();
                authorField.clear();
                quantityField.clear();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Jumlah harus berupa angka!");
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(isbnField, titleField, authorField, quantityField, submitButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.show();
    }
}