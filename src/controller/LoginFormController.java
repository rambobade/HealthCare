package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane root;

    public void btnSignIn(ActionEvent actionEvent) {
    }

    public void btnSignUp(ActionEvent actionEvent) throws IOException {


        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/RegistrationForm.fxml"));

        Scene scene = new Scene(parent);

        //Stage primaryStage = (Stage) root.getScene().getWindow();
        Stage primaryStage = (Stage) root.getScene().getWindow();

        primaryStage.setScene(scene);

        primaryStage.setTitle("Register Form");


        primaryStage.centerOnScreen();


    }
}
