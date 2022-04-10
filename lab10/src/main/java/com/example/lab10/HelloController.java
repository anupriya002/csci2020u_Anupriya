package com.example.lab10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HelloController {
    public TextField username;
    public TextField message;
    public Button send;
    public Button exit;

    public void sendMessage(ActionEvent event) throws IOException{
//        System.out.println(username.getText() + ": " + message.getText());
        try {
            //Create new socket connected to server
            Socket socket = new Socket("localhost", 6666);

            //Send message to server
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(username.getText() + ": " + message.getText() + "\n");
            writer.flush();
            username.clear();
            message.clear();

            //Close socket
            socket.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }


    }


    public void exitApp(ActionEvent event) throws IOException {
        //exit application
        System.exit(0);
    }
}