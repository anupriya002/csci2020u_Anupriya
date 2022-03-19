package com.example.lab07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Scene scene = new Scene(new Group());
        stage.setTitle("Lab 07");
        stage.setWidth(600);
        stage.setHeight(500);
        // read in csv file
        FileReader fileReader = new FileReader("weatherwarnings-2015.csv");
        BufferedReader input = new BufferedReader(fileReader);
//        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
//        PieChart pieChart = new PieChart();

        String line = null;
        String splitBy = ",";
        ArrayList allWarningTypes = new ArrayList();
        ArrayList allWarnings = new ArrayList();

        while ((line = input.readLine()) != null) {
            String[] warning = line.split(splitBy);
            String warningType = warning[5];
            allWarnings.add(warning[5]);
//            System.out.println("Warning Type: =" + warningType);
            if (!(allWarningTypes.contains(warning[5]))) {
                allWarningTypes.add(warning[5]);
            }
        }

//        get total instances of each warning type
        int count = 0;
        ArrayList totals = new ArrayList();
        for (int i = 0; i < allWarningTypes.size(); i++) {
            for (int j = 0; j < allWarnings.size(); j++) {
                if (allWarnings.get(j).equals(allWarningTypes.get(i))) {
//                    System.out.println(allWarningTypes.get(i) + ": " + allWarnings.get(j));
                    count++;
                }
            }
            System.out.println(allWarningTypes.get(i) + ": " + count);
            totals.add(count);
            count = 0;
        }

//        convert lists to arrays
        String[] all_warning_Types = new String[allWarningTypes.size()];
        allWarningTypes.toArray(all_warning_Types);

        Integer[] all_totals = new Integer[totals.size()];
        totals.toArray(all_totals);


//        add all values to pie chart
        PieChart.Data data[] = new PieChart.Data[totals.size()];

        for (int i = 0; i < totals.size(); i++) {
            data[i] = new PieChart.Data(all_warning_Types[i], all_totals[i]);
        }

        PieChart pc = new PieChart(FXCollections.observableArrayList(data));
//        Group group = new Group (pc);
        ((Group) scene.getRoot()).getChildren().add(pc);

//        scene = new Scene(group, 800, 600);

        pc.setLabelLineLength(40);
        pc.setLegendSide(Side.LEFT);


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}