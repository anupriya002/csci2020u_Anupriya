package com.example.lab06;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;


public class HelloController {

    //bar graph
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    //pie chart
    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    @FXML
    public Canvas canvas;

    @FXML
    private void initialize(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawBarChart(gc);
        drawPieChart(gc);
    }

//    private void drawBarChart(GraphicsContext gc){
//        //define width
//        float width = 10.0F;
//        //traverse avgHousingPricesByYear.length
//        for(int i = 0; i < avgHousingPricesByYear.length; i++){
//            gc.setFill(Color.RED);
//            gc.fillRect(i, avgHousingPricesByYear[i], width, avgHousingPricesByYear[i]); //based on avgHousingPricesByYear[i]
//
//            gc.setFill(Color.BLUE);
//            gc.fillRect(i, avgCommercialPricesByYear[i], width, avgCommercialPricesByYear[i]); //based on avgCommercialPricesByYear[i]
//        }
//    }
private void drawBarChart(GraphicsContext gc){
    //define width
    //float width = 10.0F;
    int yearWidth = 50;
    int width = 20;
    int bottom = 550;
    int left = 50;

    // highest value from array avgCommercialPricesByYear
    double maxValue = 1613246.3;

    //starting x
    int currentX = left + 5;

    //double x - the X position of the upper left corner of the rectangle.
    //double y - the Y position of the upper left corner of the rectangle.
    //double w - the width of the rectangle.
    //double h - the height of the rectangle.

    //traverse avgHousingPricesByYear.length
    for(int i = 0; i < avgHousingPricesByYear.length; i++){
        //hieght based on price/maxvalue
        int barHeight = (int)(avgHousingPricesByYear[i]/maxValue * 500.0);

        gc.setFill(Color.RED);
        gc.fillRect(currentX, bottom - barHeight, width, barHeight);

        barHeight = (int)(avgCommercialPricesByYear[i]/maxValue * 500.0);
        gc.setFill(Color.BLUE);
        gc.fillRect(currentX + width, bottom - barHeight, width, barHeight);

        //update x for next bar
        currentX += yearWidth;
    }
}

//    private void drawPieChart(GraphicsContext gc){
//        float start_angle = 0;
//        float arc_extent = 0;
//
//        //finding sum of all values to get angles
//        int sum = 0;
//        for(int j = 0; j < purchasesByAgeGroup.length; j++){
//            sum += purchasesByAgeGroup[j];
//        }
//
//        for(int i = 0; i < purchasesByAgeGroup.length; i++){
//            if(i == 0){
//                start_angle = 0;
//            }
//            else{
//                start_angle += arc_extent;
//            }
//
//            //finding start_angle  and arcextent
//            arc_extent = (purchasesByAgeGroup[i]/sum) * 360;
//
//            gc.setFill(pieColours[i]);
//            gc.fillArc(100, 100, 100,100, start_angle, arc_extent, ArcType.ROUND); //based on purchasedByAgeGroup[i]
//        }
//
//
//    }
private void drawPieChart(GraphicsContext gc){
    double start_angle = 0; // float to double to multiply by 360.0
    double arc_extent = 0;

    //finding ssum of all values to get angles
    int sum = 0;
    for(int j = 0; j < purchasesByAgeGroup.length; j++){
        sum += purchasesByAgeGroup[j];
    }

    for(int i = 0; i < purchasesByAgeGroup.length; i++){
        if(i == 0){
            start_angle = 0;
        }
        else{
            start_angle += arc_extent;
        }

        //finding start_angle  and arcextent
        //cast to double
        arc_extent = ((double) purchasesByAgeGroup[i]/(double) sum) * 360.0;

        gc.setFill(pieColours[i]);
        gc.fillArc(550, 100, 400,400, start_angle, arc_extent, ArcType.ROUND); //based on purchasedByAgeGroup[i]
        //move pie chart to the right ( 550, 100, 400, 400)
    }
}

}