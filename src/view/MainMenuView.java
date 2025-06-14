package view;

import controller.LibraryManager;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView extends Application {

    private LibraryManager manager = new LibraryManager();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library Information System");

        Button btnAddBook = new Button("Tambah Buku");
        btnAddBook.setOnAction(e -> AddBookView.display(manager));

        Button btnAddMember = new Button("Tambah Member");
        btnAddMember.setOnAction(e -> AddMemberView.display(manager));

        Button btnViewBooks = new Button("Lihat Semua Buku");
        btnViewBooks.setOnAction(e -> ViewBooksView.display(manager));

        Button btnExit = new Button("Keluar");
        btnExit.setOnAction(e -> primaryStage.close());

        VBox layout = new VBox(15);
        layout.getChildren().addAll(btnAddBook, btnAddMember, btnViewBooks, btnExit);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
