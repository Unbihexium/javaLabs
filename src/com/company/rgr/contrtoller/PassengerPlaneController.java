package com.company.rgr.contrtoller;

import com.company.rgr.model.CargoPlane;
import com.company.rgr.model.FireFighterPlane;
import com.company.rgr.model.PassengerPlane;
import com.company.rgr.utils.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PassengerPlaneController extends BasePlaneController {

    Logger logger = Logger.getLogger(this.getClass());

    @FXML
    TextField carryingCapacity, passengers;

    PassengerPlane plane;

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
            this.passengers.setText(Integer.toString(this.plane.getPassengers()));

        }
    }

    @Override
    void apply() {
        try {
            String model = this.model.getText();
            String manufacturer = this.manufacturer.getText();
            double range = Double.parseDouble(this.range.getText());
            int crew = Integer.parseInt(this.crew.getText());
            double carryingCapacity = Double.parseDouble(this.carryingCapacity.getText());
            int passengers = Integer.parseInt(this.passengers.getText());

            if (this.model.getText().isEmpty() ||
                    this.manufacturer.getText().isEmpty() ||
                    this.range.getText().isEmpty() ||
                    this.crew.getText().isEmpty() ||
                    this.carryingCapacity.getText().isEmpty() ||
                    this.passengers.getText().isEmpty())
                throw new Exception("Некоторые поля пусты");

            if (passengers < 0 || crew < 0 || carryingCapacity < 0 || range < 0)
                throw new IllegalArgumentException("Поля не могут быть отрицательными");

            if (plane == null) {
                logger.log("Сохранен новый пассажирский самолет");
                this.controller.save(new PassengerPlane(model, manufacturer, range, crew, carryingCapacity, passengers));
            } else {
                logger.log("Отредактирован пассажирский самолет");
                this.plane.setModel(model);
                this.plane.setManufacturer(manufacturer);
                this.plane.setCrew(crew);
                this.plane.setRangeOfFlight(range);
                this.plane.setCarryingCapacity(carryingCapacity);
                this.plane.setPassengers(passengers);
                this.controller.prepareListView();
                this.controller.recalculateStats();
            }

            logger.log("Закрыто окно пассажирский самолета");
            Stage stage = (Stage) btn.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logger.log("Ошибка ввода: неверный формат");
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверные данные");
            alert.setContentText("Некорректные данные");

            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            logger.log("Ошибка ввода: поля не могут быть отрицательными");
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверные данные");
            alert.setContentText("Поля не могут быть отрицательными");

            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            logger.log("Ошибка ввода: некоторые поля пусты");
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверные данные");
            alert.setContentText("Некоторые поля пусты");

            alert.showAndWait();
        }
    }
}
