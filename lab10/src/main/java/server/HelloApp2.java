package server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApp2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("server.fxml"));
        primaryStage.setTitle("Lab 10 Server");
        primaryStage.setScene(new Scene(root, 500, 500));
        System.out.println("Showing Window.");
        primaryStage.show();
        System.out.println("Window Shown.");
    }

    public static void main(String[] args){
        launch(args);
    }
}
