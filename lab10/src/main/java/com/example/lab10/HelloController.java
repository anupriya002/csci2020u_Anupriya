package com.example.lab10;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloController {
    @FXML private TextField messageText;
    @FXML private TextField username;
    @FXML private Button send;
    @FXML private Button exit;

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
        try (Socket sock = new Socket("localhost", 6666)){
            System.out.println("Connected to server...");
            System.out.println("Input \"done\" to terminate connection...");
            //get input from the user to send as a message
            PrintWriter dout = new PrintWriter(sock.getOutputStream(), true);

            while(!messageText.getText().equals("done")){
                dout.println(username.getText() + ": " + messageText.getText());
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Connection terminated...");
    }

    public void exit() throws IOException {

        //exit application
        System.exit(0);
    }


}