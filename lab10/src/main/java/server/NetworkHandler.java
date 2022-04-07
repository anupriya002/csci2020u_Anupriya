package server;

import java.net.ServerSocket;
import java.net.Socket;

public class NetworkHandler implements Runnable{
    private boolean keepGoing = true;
    private Controller serverController = null;
    private ServerSocket serverSocket = null;


    public NetworkHandler(Controller serverController, ServerSocket serverSocket){
        this.serverController = serverController;
        this.serverSocket = serverSocket;
    }



    public void run(){
        try{
            serverSocket = new ServerSocket(6666); //0 -> lets your OS select a port; port > 1024
            serverSocket.setReuseAddress(true);
            System.out.println("Starting server...");
            System.out.println("Listening for incoming Client Connections....");

            //create new thread
            //thread.start()....
            while(true){
                Socket sock = serverSocket.accept();
                System.out.println("Client is connected " + sock.getInetAddress().getHostAddress()); //this will display the host address of client
                NetworkHandler client = new NetworkHandler(this.serverController, serverSocket);
                new Thread(client).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        this.keepGoing = false;
    }



}
