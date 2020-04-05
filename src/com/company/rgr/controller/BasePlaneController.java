package com.company.rgr.controller;

import javafx.fxml.FXML;

import javafx.scene.control.*;

public abstract class BasePlaneController {

    @FXML
    TextField model, manufacturer, crew, range;

    @FXML
    Button btn;

    Controller controller;

    abstract void apply();

    @FXML
    void onBtnClk(){
        apply();
    }
}
