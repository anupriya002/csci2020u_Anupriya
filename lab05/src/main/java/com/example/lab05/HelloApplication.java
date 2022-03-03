package com.example.lab05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Hello!");

        TableView<StudentRecord> table = new TableView<StudentRecord>();
        table.setItems(DataSource.getAllMarks());

        TableColumn<StudentRecord,String> sidCol = new TableColumn<StudentRecord,String>("SID");
        sidCol.setCellValueFactory(new PropertyValueFactory("studentID"));

        TableColumn<StudentRecord,Float> assignmentCol = new TableColumn<StudentRecord, Float>("Assignments");
        assignmentCol.setCellValueFactory(new PropertyValueFactory("Assignments"));

        TableColumn<StudentRecord,Float> midtermCol = new TableColumn<StudentRecord,Float>("Midterm");
        midtermCol.setCellValueFactory(new PropertyValueFactory("Midterm"));

        TableColumn<StudentRecord,Float> finalExamCol = new TableColumn<StudentRecord,Float>("Final Exam");
        finalExamCol.setCellValueFactory(new PropertyValueFactory("Final Exam"));

        TableColumn<StudentRecord,Float> finalMarkCol = new TableColumn<StudentRecord,Float>("Final Mark");
        finalMarkCol.setCellValueFactory(new PropertyValueFactory("Final Mark"));

        TableColumn<StudentRecord,String> letterGradeCol = new TableColumn<StudentRecord,String>("Letter Grade");
        letterGradeCol.setCellValueFactory(new PropertyValueFactory("Letter Grade"));

        table.getColumns().setAll(sidCol, assignmentCol, midtermCol, finalExamCol, finalMarkCol, letterGradeCol);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}