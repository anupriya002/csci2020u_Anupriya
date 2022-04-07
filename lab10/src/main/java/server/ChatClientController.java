package server;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientController implements Runnable{
    private Controller serverController = null;
    private Socket socket = null;
    private boolean keepRunning = true;

    @FXML
    private TextField messageText;
    @FXML private TextField username;

    public ChatClientController(Controller serverController, Socket socket){
        this.serverController = serverController;
        this.socket = socket;

    }

    public void stop(){
        this.keepRunning = false;

    }

    public void sendMessage(String Message){
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

    public void run(){
        System.out.println(Thread.currentThread().getName() + ": Listening for client data...");
    }


}
