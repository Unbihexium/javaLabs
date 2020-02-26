package com.company.rgr.contrtoller;

import com.company.rgr.model.Plane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

public class FuelRangeController {

    @FXML
    ListView<Plane> planesListView;

    Plane[] planes;

    private Callback<ListView<Plane>, ListCell<Plane>> callback;

    public FuelRangeController(){
        callback = new Callback<ListView<Plane>, ListCell<Plane>>() {
            @Override
            public ListCell<Plane> call(ListView<Plane> planeListView) {
                ListCell<Plane> cell = new ListCell<Plane>(){
                    @Override
                    protected void updateItem(Plane t, boolean empty) {
                        super.updateItem(t, empty);
                        if (empty || t == null) {
                            setText(null);
                            return;
                        }
                        setText(t.getManufacturer() + " " + t.getModel() + ", Дальность: " + t.getRangeOfFlight());
                    }
                };
                return cell;
            }
        };
    }


    public void prepare(){
        ObservableList<Plane> observableList = FXCollections.observableArrayList(planes);
        planesListView.setItems(observableList);
        planesListView.setCellFactory(callback);

    }
}
