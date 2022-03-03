package com.example.lab05;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

//    @FXML
//    private TableView<StudentRecord> tabView;
//
//    @FXML
//    private void initialize(){
//        tabView.setItems(DataSource.getAllMarks());
//    }
}