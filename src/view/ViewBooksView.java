package view;

import controller.LibraryManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Book;

public class ViewBooksView {

    public static void display(LibraryManager manager) {
        Stage window = new Stage();
        window.setTitle("Daftar Buku");

        TableView<Book> table = new TableView<>();

        TableColumn<Book, String> isbnColumn = new TableColumn<>("ISBN");
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));

        TableColumn<Book, String> titleColumn = new TableColumn<>("Judul");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Penulis");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, Integer> quantityColumn = new TableColumn<>("Jumlah");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        ObservableList<Book> books = FXCollections.observableArrayList(manager.getAllBooks());
        table.setItems(books);
        table.getColumns().addAll(isbnColumn, titleColumn, authorColumn, quantityColumn);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(table);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 500, 400);
        window.setScene(scene);
        window.show();
    }
}
