package com.company.rgr.contrtoller;

import com.company.rgr.utils.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller {

    Logger logger = new Logger(this.getClass());

    public void mouseClicked(){
        logger.log("Tag", "Message");
    }

}
