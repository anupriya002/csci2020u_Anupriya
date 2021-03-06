package com.example.lab04;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
public class HelloController {
    @FXML
    private Label usernameLabel;
    @FXML
    private TextField usernameField;

    //    password
    @FXML
    private Label passwordLabel;
    @FXML
    private PasswordField passwordField;

    // fullname
    @FXML
    private Label fullnameLabel;
    @FXML
    private TextField fullnameField;

    // email
    @FXML
    private Label emailLabel;
    @FXML
    private TextField emailField;

    // phone
    @FXML
    private Label phoneLabel;
    @FXML
    private TextField phoneField;

    // Date of Birth

    @FXML
    private Label dateLabel;
    @FXML
    private DatePicker dateField;

    @FXML
    protected void handleSubmitButton() {
        usernameLabel.setText("Username: " + usernameField.getText());
        usernameField.clear();

        passwordLabel.setText("Password: " + passwordField.getText());
        passwordField.clear();

        fullnameLabel.setText("FullName: " + fullnameField.getText());
        fullnameField.clear();

        emailLabel.setText("Email: " + emailField.getText());
        emailField.clear();

        String s1 = phoneField.getText();
        String phonePattern = "(\\d{3})(\\d{3})(\\d{4})"; // digits format: 3 - 3 - 4
        String phoneFormat = "$1-$2-$3";
        String replaceString= s1.replaceAll(phonePattern,phoneFormat);
        phoneLabel.setText("Phone #: " + replaceString);
        phoneField.clear();

        dateLabel.setText("Date of Birth: " + dateField.getValue());
//        dateField.clear();
    }
}