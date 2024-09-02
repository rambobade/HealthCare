package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationFormController {
    public TextField txtFullName;
    public TextField txtMobile;
    public TextField txtConfirmPassword;
    public TextField txtPassword;
    public Label lblpassword1;
    public Label lblpassword2;



    public void initialize()
    {
        lblpassword1.setVisible(false);
        lblpassword2.setVisible(false);
    }


    public void btnSignUp(ActionEvent actionEvent) throws IOException {

        register();

    }

    public void txtConfirmPasswordOnAction(ActionEvent actionEvent) {
        register();
    }

    public void register()
    {
        String newPassword = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if(newPassword.equals(confirmPassword))
        {
            setBorderColor("transparent");
            lblpassword1.setVisible(false);
            lblpassword2.setVisible(false);
            txtPassword.requestFocus();
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
