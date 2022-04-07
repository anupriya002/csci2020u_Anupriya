package com.example.lab10;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloController {
    @FXML private TextField messageText;
    @FXML private TextField username;

    private Socket socket = null;
    private PrintWriter out = null;

    public void initialize(){
        try{
            this.socket = new Socket("127.0.0.1", 8001);
            this.out = new PrintWriter(this.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        //define user +  message text..

        try (Socket sock = new Socket("localhost", 6666)){
            System.out.println("Connected to server...");
            System.out.println("Input \"done\" to terminate connection...");
            //get input from the user to send as a message
            PrintWriter dout = new PrintWriter(sock.getOutputStream(), true);
            String message = "";
            String user = "";
            while(!message.equals("done")){
                message = messageText.getText();
                user = username.getText();
                dout.println(user + ": " + message);
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public void exit() throws IOException {
        //close the socket connection
        socket.close();

        //exit the program
        System.exit(0);
    }



}



//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }