package com.company.rgr.controller;

import com.company.rgr.model.CargoPlane;
import com.company.rgr.model.FireFighterPlane;
import com.company.rgr.utils.Logger;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.stage.Stage;

public class FireFighterController extends BasePlaneController {

    Logger logger = Logger.getLogger(this.getClass());

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
        try {
            String model = this.model.getText();
            String manufacturer = this.manufacturer.getText();
            double range = Double.parseDouble(this.range.getText());
            int crew = Integer.parseInt(this.crew.getText());
            double water = Double.parseDouble(this.water.getText());

            if (this.model.getText().isEmpty() ||
                    this.manufacturer.getText().isEmpty() ||
                    this.range.getText().isEmpty() ||
                    this.crew.getText().isEmpty() ||
                    this.water.getText().isEmpty())
                throw new Exception("Некоторые поля пусты");

            if (crew < 0 || water < 0 || range < 0)
                throw new IllegalArgumentException("Поля не могут быть отрицательными");

            if (plane == null) {
                logger.log("Сохранен новый пожарный самолет");
                this.controller.save(new CargoPlane(model, manufacturer, range, crew, water));
            } else {
                logger.log("Отредактирован пожарный самолет");
                this.plane.setModel(model);
                this.plane.setManufacturer(manufacturer);
                this.plane.setCrew(crew);
                this.plane.setRangeOfFlight(range);
                this.plane.setWaterCapacity(water);
                this.controller.prepareListView();
                this.controller.recalculateStats();
            }

            logger.log("Закрыто окно пожарного самолета");
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
