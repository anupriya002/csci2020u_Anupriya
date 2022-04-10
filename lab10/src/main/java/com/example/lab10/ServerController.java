package com.example.lab10;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;


public class ServerController implements Initializable {

    public TextArea serverMessages;
    public Button exit;

    public void initialize(URL location, ResourceBundle resources) {
//        serverMessages.setEditable(false);

        //Create new thread for server
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Create server
                    ServerSocket server = new ServerSocket(6666);
//                    System.out.println("Server online");

                    //Accept connections, add messages to text area
                    while(true) {
                        Socket socket = server.accept();
                        BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String username;
                        String message;
                        while((username = inStream.readLine()) != null) {
                            serverMessages.appendText(username + ": ");
                            while ((message = inStream.readLine()) != null){
                                serverMessages.appendText(message + "\n\n");
                            }
                        }
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


    public void exitApp(ActionEvent event) throws IOException {
        //exit application
        System.exit(0);
    }



}