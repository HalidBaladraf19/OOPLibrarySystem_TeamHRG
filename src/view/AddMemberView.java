package view;

import controller.LibraryManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Member;

public class AddMemberView {

    public static void display(LibraryManager manager) {
        Stage window = new Stage();
        window.setTitle("Tambah Member Baru");

        TextField idField = new TextField();
        idField.setPromptText("ID Member");

        TextField nameField = new TextField();
        nameField.setPromptText("Nama Lengkap");

        TextField majorField = new TextField();
        majorField.setPromptText("Jurusan");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        Button submitButton = new Button("Tambah Member");
        submitButton.setOnAction(e -> {
            Member member = new Member(
                    idField.getText(),
                    nameField.getText(),
                    majorField.getText(),
                    emailField.getText()
            );
            manager.addMember(member);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sukses");
            alert.setHeaderText(null);
            alert.setContentText("Member berhasil ditambahkan!");
            alert.showAndWait();

            idField.clear();
            nameField.clear();
            majorField.clear();
            emailField.clear();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(idField, nameField, majorField, emailField, submitButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 350);
        window.setScene(scene);
        window.show();
    }
}
