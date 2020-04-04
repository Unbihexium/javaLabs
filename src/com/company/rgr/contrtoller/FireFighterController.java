package com.company.rgr.contrtoller;

import com.company.rgr.model.CargoPlane;
import com.company.rgr.model.FireFighterPlane;
import com.company.rgr.model.PassengerPlane;
import com.company.rgr.utils.PlaneTypes;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.stage.Stage;

public class FireFighterController extends BasePlaneController {

    @FXML
    TextField water;

    FireFighterPlane plane;

    @FXML
    public void initialize() {
        if (this.plane == null) {
            this.btn.setText("Добавить");
        } else {
            this.btn.setText("Сохранить");

            this.model.setText(this.plane.getModel());
            this.manufacturer.setText(this.plane.getManufacturer());
            this.crew.setText(Integer.toString(this.plane.getCrew()));
            this.range.setText(Double.toString(this.plane.getRangeOfFlight()));
            this.water.setText(Double.toString(this.plane.getWaterCapacity()));
        }
    }

    @Override
    void apply() {
        // TODO: Exceptions
        String model = this.model.getText();
        String manufacturer = this.manufacturer.getText();
        double range = Double.parseDouble(this.range.getText());
        int crew = Integer.parseInt(this.crew.getText());
        double water1 = Double.parseDouble(this.water.getText());

        if (plane == null) {
            this.controller.save(new FireFighterPlane(model, manufacturer, range, crew, water1));
        } else {
            this.plane.setModel(model);
            this.plane.setManufacturer(manufacturer);
            this.plane.setCrew(crew);
            this.plane.setRangeOfFlight(range);
            this.plane.setWaterCapacity(water1);
            this.controller.prepareListView();
            this.controller.recalculateStats();
        }
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();

    }
}
