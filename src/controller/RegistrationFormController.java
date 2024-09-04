package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RegistrationFormController {
    public TextField txtFullName;
    public TextField txtMobile;
    public TextField txtConfirmPassword;
    public AnchorPane pane;
    public TextField txtPassword;
    public Label lblpassword1;
    public Label lblpassword2;
    public Label lblAutoID;


    public void initialize() throws SQLException {
        lblpassword1.setVisible(false);
        lblpassword2.setVisible(false);
        AutoID();

    }

    public void AutoID() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from user order by id desc limit 1");
            boolean a = resultSet.next();

            if(a)
            {
                String uid = resultSet.getString(1);
                uid = uid.substring(1,4);
                int intID = Integer.parseInt(uid);

                intID++;

                if(intID<10)
                {
                    lblAutoID.setText("U00" + intID);
                }

                else if (intID<100)
                {
                    lblAutoID.setText("U0" + intID);
                }

                else
                {
                    lblAutoID.setText("U" + intID);
                }

                System.out.println(intID);

            }

            else
            {   lblAutoID.setText("U001");
                System.out.println("U001");
            }

    }


    public void btnSignUp(ActionEvent actionEvent) throws IOException, SQLException {

        register();

        DBConnection object = DBConnection.getInstance();
        System.out.println(object);

        DBConnection object2 = DBConnection.getInstance();
        System.out.println(object2);




    }

    public void txtConfirmPasswordOnAction(ActionEvent actionEvent) throws SQLException {
        register();
    }

    public void register() throws SQLException {
        String newPassword = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if(newPassword.equals(confirmPassword))
        {
            setBorderColor("transparent");
            lblpassword1.setVisible(false);
            lblpassword2.setVisible(false);
            txtPassword.requestFocus();

            try {
                Connection connection = DBConnection.getInstance().getConnection();

                String id = lblAutoID.getText();
                String name = txtFullName.getText();
                String mobile = txtMobile.getText();
                String cpass = txtConfirmPassword.getText();


                PreparedStatement preparedStatement = connection.prepareStatement("insert into user(id,username,email,password)values(?,?,?,?)");
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, mobile);
                preparedStatement.setString(4, cpass);


                int i = preparedStatement.executeUpdate();

                if (i != 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Success");
                    alert.showAndWait();

                    Parent parent = FXMLLoader.load(this.getClass().getResource("../view/LoginForm.fxml"));
                    Scene scene = new Scene(parent);

                    Stage primaryStage = (Stage) pane.getScene().getWindow();

                    primaryStage.setScene(scene);
                    primaryStage.setTitle("Login Form");
                    primaryStage.centerOnScreen();

                }
            }

            catch (SQLException | IOException ex)
            {
                ex.printStackTrace();
            }
        }

        else
        {
            setBorderColor("red");
            lblpassword1.setVisible(true);
            lblpassword2.setVisible(true);
            txtPassword.requestFocus();
        }

    }

    public void setBorderColor(String color)
    {
        txtPassword.setStyle("-fx-border-color:" + color);
        txtConfirmPassword.setStyle("-fx-border-color:" + color);
    }


}
