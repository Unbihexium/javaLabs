package com.company.rgr.controller;

import com.company.rgr.model.AbstractPlane;
import com.company.rgr.model.CargoPlane;
import com.company.rgr.model.FireFighterPlane;
import com.company.rgr.model.PassengerPlane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class RangeOfFlightController {

    @FXML
    ListView<AbstractPlane> planesListView;

    AbstractPlane[] planes;

    private Callback<ListView<AbstractPlane>, ListCell<AbstractPlane>> callback;

    public RangeOfFlightController(){
        callback = new Callback<ListView<AbstractPlane>, ListCell<AbstractPlane>>() {
            @Override
            public ListCell<AbstractPlane> call(ListView<AbstractPlane> planeListView) {
                return new ListCell<AbstractPlane>(){
                    @Override
                    protected void updateItem(AbstractPlane t, boolean empty) {
                        super.updateItem(t, empty);
                        if (empty || t == null) {
                            setText(null);
                            return;
                        }

                        if (t instanceof CargoPlane)
                            setText("CargoPlane: " + t.getManufacturer() + " " + t.getModel() + ", Дальность: " + t.getRangeOfFlight());
                        if (t instanceof PassengerPlane)
                            setText("PassengerPlane: " + t.getManufacturer() + " " + t.getModel() + ", Дальность: " + t.getRangeOfFlight());
                        if (t instanceof FireFighterPlane)
                            setText("FirefighterPlane: " + t.getManufacturer() + " " + t.getModel() + ", Дальность: " + t.getRangeOfFlight());
                    }
                };
            }
        };
    }


    public void prepare(){
        ObservableList<AbstractPlane> observableList = FXCollections.observableArrayList(planes);
        planesListView.setItems(observableList);
        planesListView.setCellFactory(callback);
    }
}
