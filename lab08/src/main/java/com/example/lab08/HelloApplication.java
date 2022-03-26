package com.example.lab08;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class HelloApplication extends Application {
    File currentFileName = new File("src/main/resources/saved_table_data.csv");
    //create a table here
    TableView<StudentRecord> table = new TableView<StudentRecord>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Lab 08");

        //create instance of current filename to store its name

        Menu file = new Menu("File");
        MenuItem item1 = new MenuItem("New");
        MenuItem item2 = new MenuItem("Open");
        MenuItem item3 = new MenuItem("Save");
        MenuItem item4 = new MenuItem("SaveAs");
        MenuItem item5 = new MenuItem("Exit");

        //add all menu items to menu
        file.getItems().addAll(item1, item2, item3, item4, item5);

        //add menu to menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.setTranslateX(0);
        menuBar.setTranslateY(0);
        //Adding all the menus to the menu bar
        menuBar.getMenus().add(file);

        // populate the table
        TableColumn<StudentRecord,String> sidCol = new TableColumn<StudentRecord,String>("SID");
        sidCol.setCellValueFactory(new PropertyValueFactory<>("studentID"));

        TableColumn<StudentRecord,Float> assignmentCol = new TableColumn<StudentRecord, Float>("Assignments");
        assignmentCol.setCellValueFactory(new PropertyValueFactory("assignmentGrade"));

        TableColumn<StudentRecord,Float> midtermCol = new TableColumn<StudentRecord,Float>("Midterm");
        midtermCol.setCellValueFactory(new PropertyValueFactory("midtermGrade"));

        TableColumn<StudentRecord,Float> finalExamCol = new TableColumn<StudentRecord,Float>("Final Exam");
        finalExamCol.setCellValueFactory(new PropertyValueFactory("finalExamGrade"));

        TableColumn<StudentRecord,Float> finalMarkCol = new TableColumn<StudentRecord,Float>("Final Mark");
        finalMarkCol.setCellValueFactory(new PropertyValueFactory("finalMark"));

        TableColumn<StudentRecord,String> letterGradeCol = new TableColumn<StudentRecord,String>("Letter Grade");
        letterGradeCol.setCellValueFactory(new PropertyValueFactory("letterGrade"));

        table.getColumns().setAll(sidCol, assignmentCol, midtermCol, finalExamCol, finalMarkCol, letterGradeCol);
        table.setItems(DataSource.getAllMarks());

        table.setTranslateX(60);
        table.setTranslateY(28);
        table.setMaxSize(600, 600);


        //call functions according to menu item clicked

        //"new" clicked
        item1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //clear all items form table view
                table.getItems().clear();
            }
        });

        //"open" clicked
        item2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //show a filechooser to Update the currentFilename variable to the user-selected file’s filename
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                currentFileName = selectedFile;

                //call load
                try {
                    load(currentFileName, table);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //"save" clicked
        item3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                try {
                    save(currentFileName, table);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //"Save As" clicked
        item4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //show a filechooser to Update the currentFilename variable to the user-selected file’s filename
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                currentFileName = selectedFile;

                //call the save function
                try {
                    save(currentFileName, table);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //"Exit" clicked
        item5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //exit the application
                System.exit(0);
            }
        });
        
        Group root = new Group(menuBar, table);
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    //save function
    public void save(File currentFileName, TableView<StudentRecord> table) throws IOException { //save from table to csv
    //save SID, Assignments, Midterm, Final Exam to csv file
        ObservableList<StudentRecord> marks = table.getItems();
        FileWriter fileWriter = new FileWriter(currentFileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String currentStudent = "";

        for (int i = 0; i < marks.size() + 1; i++){
            if (i == 0){
                currentStudent = "SID,AssignmentGrade,MidtermGrade,FinalExamGrade";

            }
            else{
                currentStudent = marks.get(i-1).getStudentID() + "," + Float.toString(marks.get(i-1).getAssignmentGrade())
                        + "," + Float.toString(marks.get(i-1).getMidtermGrade()) + "," + Float.toString(marks.get(i-1).getFinalExamGrade());
            }

            printWriter.println(currentStudent);
        }
        printWriter.close();

    }

    //load from csv to table
    public void load(File currentFileName, TableView<StudentRecord> table) throws IOException {
        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        //read data from csv file and store it in a list
        FileReader fileReader = new FileReader(currentFileName);
        BufferedReader input = new BufferedReader(fileReader);
        String line = null;
        String splitBy = ",";

        while ((line = input.readLine()) != null) {
            String[] studentData = line.split(splitBy);
            if(!line.startsWith("S")){
                StudentRecord student = new StudentRecord(studentData[0],Float.parseFloat(studentData[1]),Float.parseFloat(studentData[2]),Float.parseFloat(studentData[3]));
                marks.add(student);
            }
            }

        //add data from csv file to table
        TableColumn<StudentRecord,String> sidCol = new TableColumn<StudentRecord,String>("SID");
        sidCol.setCellValueFactory(new PropertyValueFactory<>("studentID"));

        TableColumn<StudentRecord,Float> assignmentCol = new TableColumn<StudentRecord, Float>("Assignments");
        assignmentCol.setCellValueFactory(new PropertyValueFactory("assignmentGrade"));

        TableColumn<StudentRecord,Float> midtermCol = new TableColumn<StudentRecord,Float>("Midterm");
        midtermCol.setCellValueFactory(new PropertyValueFactory("midtermGrade"));

        TableColumn<StudentRecord,Float> finalExamCol = new TableColumn<StudentRecord,Float>("Final Exam");
        finalExamCol.setCellValueFactory(new PropertyValueFactory("finalExamGrade"));

        TableColumn<StudentRecord,Float> finalMarkCol = new TableColumn<StudentRecord,Float>("Final Mark");
        finalMarkCol.setCellValueFactory(new PropertyValueFactory("finalMark"));

        TableColumn<StudentRecord,String> letterGradeCol = new TableColumn<StudentRecord,String>("Letter Grade");
        letterGradeCol.setCellValueFactory(new PropertyValueFactory("letterGrade"));

        table.getColumns().setAll(sidCol, assignmentCol, midtermCol, finalExamCol, finalMarkCol, letterGradeCol);
        table.setItems(marks);

        table.setTranslateX(60);
        table.setTranslateY(28);
        table.setMaxSize(600, 600);

    }


    public static void main(String[] args) {
        launch();
    }
}