package com.company.rgr.contrtoller;

import com.company.rgr.Main;
import com.company.rgr.utils.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    Logger logger = Logger.getLogger(this.getClass());

    public void mouseClicked(){
        logger.log("Tag", "Message");

    }

    public void startNewWindow() throws IOException {
        // Старт нового окна
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new AddEditPlane());
        loader.setLocation(getClass().getResource("../view/AddEditPlane.fxml"));
        Stage newWindow = new Stage();
        ((AddEditPlane)loader.getController()).parent = this;
        newWindow.setTitle("Second Stage");
        newWindow.setX(0);
        newWindow.setY(0);
        newWindow.setScene(new Scene(loader.load(), 300, 275));
        newWindow.show();
    }

    public void test(){
        System.out.println("TEST");
    }

}
