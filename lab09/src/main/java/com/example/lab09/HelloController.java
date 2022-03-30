package com.example.lab09;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HelloController {
    @FXML
    Canvas canvas;

    public void initialize(){
        ArrayList<Float> stockPrices1 = downloadStockPrices("AAPL");
        ArrayList<Float> stockPrices2 = downloadStockPrices("GOOG");

        drawLineChart(stockPrices1, stockPrices2);
    }

    private ArrayList<Float> downloadStockPrices(String symbol){
        ArrayList<Float> stockPrices = new ArrayList<>();

        //Interval boundaries
        long periodStart = LocalDate.of(2010, 1, 1).atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
        long periodEnd = LocalDate.of(2015, 12, 31).atStartOfDay(ZoneId.systemDefault()).toEpochSecond();

        try{
            URL url = new URL("https://query1.finance.yahoo.com/v7/finance/download/" + symbol + "?period1=" + periodStart + "&period2=" + periodEnd + "&interval=1mo&events=history&includeAdjustedClose=true");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(false);
            conn.setDoInput(true);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = in.readLine(); //skip the first line
            while ((line = in.readLine()) != null){
                String[] data = line.split(",");
                stockPrices.add(Float.parseFloat(data[4]));
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stockPrices;
    }

    private void drawLineChart(ArrayList<Float> stockPrices1, ArrayList<Float> stockPrices2){
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //clear the canvas
        //setfill color white
        //fillrect ..
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 800, 800);

        //move x and y axis 50 pixels to left and bottom edge
        //define top, left, bottom, right
        int top = 20;
        int left = 50;
        int bottom = 750;
        int right = 650;

        //draw the axes
        //setStroke color black
        gc.setStroke(Color.BLACK);
        gc.strokeLine(left, top, left, bottom); //to set y axis
        gc.strokeLine(left, bottom, right, bottom); // to set x axis

        //find the y limit
            //get the min and max values of each stockPrice list
        Float min1 = Collections.min(stockPrices1); // min val of stockPrices1
        Float max1 = Collections.max(stockPrices1); //max val of stockPrices1

        Float min2 = Collections.min(stockPrices2); // min val of stockPrices2
        Float max2 = Collections.max(stockPrices2); //max val of stockPrices2


        //draw the plot for stockPrices1
            //call plotLine()
        plotLine(gc, stockPrices1, Color.RED, min1, max1);

        //draw the plot for stockPrices2
            //call plotline()
        plotLine(gc, stockPrices2, Color.BLUE, min2, max2);
    }

    private void plotLine(GraphicsContext gc, ArrayList<Float> stockPrices, Color color, double min, double max){
        double startingX = 50;

        for (int i = 0; i < stockPrices.size()-1; i++){
            gc.setStroke(color);
            gc.strokeLine(startingX,750 - stockPrices.get(i), startingX + 7, 750 - stockPrices.get(i+1));

            //update starting x value
            startingX += 7;
        }
    }

}

//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }