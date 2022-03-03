package com.example.lab05;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

public class HelloController {
    private DataSource source = new DataSource();

    @FXML
    private TableView<StudentRecord> tableView = new TableView<StudentRecord>();;

    @FXML
    private TableColumn<StudentRecord, String> idColumn;

    @FXML
    private TableColumn<StudentRecord, Float> midtermColumn;

    @FXML
    private TableColumn<StudentRecord, Float> assignmentColumn;

    @FXML
    private TableColumn<StudentRecord, Float> FinalExamColumn;

    @FXML
    private TableColumn<StudentRecord, Float> FinalMarkColumn;

    @FXML
    private TableColumn<StudentRecord, String> LetterGradeColumn;

    @FXML
    private void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("studentID"));
        midtermColumn.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("midtermGrade"));
        assignmentColumn.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("assignmentGrade"));
        FinalExamColumn.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("finalExamGrade"));
        FinalMarkColumn.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("finalMark"));
        LetterGradeColumn.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("letterGrade"));
        tableView.setItems(DataSource.getAllMarks());
    }
}