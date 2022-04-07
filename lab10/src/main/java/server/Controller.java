package server;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Controller {
    @FXML private TextArea messages;

    private List<ChatClientController> clientHandler;
    private boolean keepGoing = true;
    private ServerSocket serverSocket = null;
    private NetworkHandler listener = null;

    private final Socket clientSock;

    public Controller(Socket socket){
        clientSock = socket;
    }



    public void initialize(){
        try{
            this.serverSocket = new ServerSocket(6666);
//            this.listener = new NetworkHandler(serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addClientHandler(ChatClientController newHandler){
        this.clientHandler.add(newHandler);
    }

    public void addMessage(String message){


        BufferedReader inStream = null;
        try {
            inStream = new BufferedReader(new InputStreamReader(this.clientSock.getInputStream()));

            PrintWriter dout = new PrintWriter(sock.getOutputStream(), true);
            String newMessage = "";
            while ((message = inStream.readLine()) != null){
                newMessage = message;
                dout.println(newMessage);

            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                inStream.close();
                clientSock.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }




}

    public void exit() throws IOException {
        //stop all the client handler threads
        for (int i = 0; i < clientHandler.size(); i++){
            clientHandler.get(i).stop();
        }

        //close the server socket and listener
        serverSocket.close();
        listener.stop();

        //exit
        System.exit(0);
    }
}
