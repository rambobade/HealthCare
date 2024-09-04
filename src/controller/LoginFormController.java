package controller;

import db.DBConnection;
import javafx.embed.swing.JFXPanel;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane root;
    public AnchorPane pane;



    public void btnSignIn(ActionEvent actionEvent) {

        try {

            String userName = txtUserName.getText();
            String password = txtPassword.getText();

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username =? and password =?");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next())
            {
                System.out.println("logged in");
                Parent parent = FXMLLoader.load(this.getClass().getResource("../view/MainForm.fxml"));
                System.out.println("im here");
                Scene scene = new Scene(parent);
                System.out.println("im here2");

                Stage primaryStage = (Stage) root.getScene().getWindow();
                System.out.println("im here3");

                primaryStage.setScene(scene);
                System.out.println("im here4");
                primaryStage.setTitle("Main Form");
                System.out.println("im here5");
                primaryStage.centerOnScreen();
                System.out.println("im here6");
            }

            else
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Username or password do not match");
                alert.showAndWait();
                txtUserName.clear();
                txtPassword.clear();
                txtUserName.requestFocus();
            }



        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }

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
