package com.company.rgr.contrtoller;

import com.company.rgr.model.Plane;
import com.company.rgr.utils.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditPlane {

    Logger logger = Logger.getLogger(this.getClass());

    // Делегат для добавления самолета
    Controller parent;

    Plane plane;

    //Controls
    @FXML
    Button apply;

    @FXML
    TextField etManufacturer, etModel, etFuelCapacity, etPassengerCapacity, etCarryingCapacity, etRangeOfFlight;

    public AddEditPlane() {}

    public AddEditPlane(Plane plane) {
        this.plane = plane;
    }

    public void onClick(){
        String manufacturer = etManufacturer.getText();
        String model = etModel.getText();
        double fuel = Double.parseDouble(etFuelCapacity.getText());
        int passenger = Integer.parseInt(etPassengerCapacity.getText());
        double carry = Double.parseDouble(etCarryingCapacity.getText());
        double range = Double.parseDouble(etRangeOfFlight.getText());
        if (plane == null) {
            Plane plane = new Plane(model, manufacturer, fuel, passenger, carry, range);
            parent.save(plane);
        } else {
            plane.setModel(model);
            plane.setManufacturer(manufacturer);
            plane.setFuelConsumption(fuel);
            plane.setPassengerCapacity(passenger);
            plane.setCarryingCapacity(carry);
            plane.setRangeOfFlight(range);
            parent.recalculateStats();
        }
        parent.prepareListView();
        Stage stage = (Stage) apply.getScene().getWindow();
        stage.close();
    }

    public void prepare(){
        if (plane != null){
            apply.setText("Edit");
            etManufacturer.setText(plane.getManufacturer());
            etModel.setText(plane.getModel());
            etFuelCapacity.setText(Double.toString(plane.getFuelConsumption()));
            etPassengerCapacity.setText(Integer.toString(plane.getPassengerCapacity()));
            etCarryingCapacity.setText(Double.toString(plane.getCarryingCapacity()));
            etRangeOfFlight.setText(Double.toString(plane.getRangeOfFlight()));
        } else {
            apply.setText("Add");
        }
    }
}
