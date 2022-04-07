package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkHandler implements Runnable{
    private boolean keepGoing = true;
    private Controller serverController = null;
    private ServerSocket serverSocket = null;

    private Socket socket = null;
    private PrintWriter out = null;

    public NetworkHandler(Controller serverController, ServerSocket serverSocket){
        this.serverController = serverController;
        this.serverSocket = serverSocket;
    }

    public void run(){
        BufferedReader inStream = null;
        try {
            inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message;
            while ((message = inStream.readLine()) != null){
                System.out.println(message);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                inStream.close();
                socket.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

    }

    public void stop(){
        this.keepGoing = false;
    }


}


//complete
//        try{
//                System.out.println("Listening for incoming client connections ....");
//                //create new thread thread1
////            Thread thread1 = new Thread();
////            thread1.start();
//
//
//                } catch (Exception e) {
//                e.printStackTrace();
//                }