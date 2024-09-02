package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationFormController {
    public TextField txtFullName;
    public TextField txtMobile;
    public TextField txtConfirmPassword;
    public TextField txtPassword;

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
            System.out.println("I was read matched");
            setBorderColor("transparent");
        }

        else
        {
            System.out.println("I was read red");
            setBorderColor("red");
        }
    }

    public void setBorderColor(String color)
    {
        txtPassword.setStyle("-fx-border-color:" + color);
        txtConfirmPassword.setStyle("-fx-border-color:" + color);
    }


}
