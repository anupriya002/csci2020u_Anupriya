package com.example.lab05;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class HelloController {

    @FXML
    TableView<StudentRecord> table = new TableView<StudentRecord>();


    TableColumn<StudentRecord,String> sidCol = new TableColumn<StudentRecord,String>("SID");


    TableColumn<StudentRecord,Float> assignmentCol = new TableColumn<StudentRecord, Float>("Assignments");


    TableColumn<StudentRecord,Float> midtermCol = new TableColumn<StudentRecord,Float>("Midterm");


    TableColumn<StudentRecord,Float> finalExamCol = new TableColumn<StudentRecord,Float>("Final Exam");


    TableColumn<StudentRecord,Float> finalMarkCol = new TableColumn<StudentRecord,Float>("Final Mark");


    TableColumn<StudentRecord,String> letterGradeCol = new TableColumn<StudentRecord,String>("Letter Grade");


    @FXML
    private void initialize(){
        sidCol.setCellValueFactory(new PropertyValueFactory("studentID"));
        assignmentCol.setCellValueFactory(new PropertyValueFactory("assignmentGrade"));
        midtermCol.setCellValueFactory(new PropertyValueFactory("midtermGrade"));
        finalExamCol.setCellValueFactory(new PropertyValueFactory("finalExamGrade"));
        finalMarkCol.setCellValueFactory(new PropertyValueFactory("finalMark"));
        letterGradeCol.setCellValueFactory(new PropertyValueFactory("letterGrade"));
        table.getColumns().setAll(sidCol, assignmentCol, midtermCol, finalExamCol, finalMarkCol, letterGradeCol);
        table.setItems(DataSource.getAllMarks());

    }

}