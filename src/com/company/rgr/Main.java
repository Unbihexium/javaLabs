package com.company.rgr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Total hours wasted here: 14

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("view/Main.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
