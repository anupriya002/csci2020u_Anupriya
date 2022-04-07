package server;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Controller {
    @FXML private TextArea messages;
    @FXML private Button exit;

    private List<ChatClientController> clientHandler;
    private boolean keepGoing = true;
    private ServerSocket serverSocket = null;
    private NetworkHandler listener = null;

    public void initialize(){
        //complete
        try{
            this.serverSocket= new ServerSocket(6666);
            serverSocket.setReuseAddress(true);
            System.out.println("Starting server...");
            System.out.println("Waiting for client connection...");

            while(true){
                Socket sock = serverSocket.accept();
                System.out.println("Client is connected " + sock.getInetAddress().getHostAddress()); //this will display the host address of client

                new Thread(listener).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClientHandler(ChatClientController newHandler){
        this.clientHandler.add(newHandler);
    }

    public void addMessage(String message){
        messages.appendText(message);

    }

    public void exit(){
        System.exit(0);
    }
}
