package com.company.rgr.contrtoller;

import com.company.rgr.model.CargoPlane;
import com.company.rgr.model.PassengerPlane;
import com.company.rgr.utils.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CargoPlaneController extends BasePlaneController {

    Logger logger = Logger.getLogger(this.getClass());

    @FXML
    TextField carryingCapacity;

    CargoPlane plane;

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
            this.carryingCapacity.setText(Double.toString(this.plane.getCarryingCapacity()));
        }
    }

    @Override
    void apply() {

        // TODO: Exceptions
        String model = this.model.getText();
        String manufacturer = this.manufacturer.getText();
        double range = Double.parseDouble(this.range.getText());
        int crew = Integer.parseInt(this.crew.getText());
        double carryingCapacity = Double.parseDouble(this.carryingCapacity.getText());
        if (plane == null) {
            logger.log("Сохранен новый грузовой самолет");
            this.controller.save(new CargoPlane(model, manufacturer, range, crew, carryingCapacity));
        } else {
            logger.log("Отредактирован грузовой самолет");
            this.plane.setModel(model);
            this.plane.setManufacturer(manufacturer);
            this.plane.setCrew(crew);
            this.plane.setRangeOfFlight(range);
            this.plane.setCarryingCapacity(carryingCapacity);
            this.controller.prepareListView();
            this.controller.recalculateStats();
        }
        logger.log("Закрыто окно грузового самолета");
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }
}
