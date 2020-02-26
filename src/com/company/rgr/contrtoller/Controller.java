package com.company.rgr.contrtoller;

import com.company.rgr.Main;
import com.company.rgr.model.Plane;
import com.company.rgr.utils.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import javafx.event.EventHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Controller {

    Logger logger = Logger.getLogger(this.getClass());

    ArrayList<Plane> planes = new ArrayList<>();
    @FXML
    ListView<Plane> planesListView;

    @FXML
    Label lWeightTotal, lPassengerTotal;

    @FXML
    TextField etFuelFrom, etFuelTo;

    private Callback<ListView<Plane>, ListCell<Plane>> callback;
    private EventHandler<MouseEvent> doubleClick;
    private EventHandler<KeyEvent> deleteEvent;

    public Controller(){
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

        doubleClick = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    Plane item = null;
                    item = planesListView.getSelectionModel()
                            .getSelectedItem();
                    if (item != null) {
                        try {
                            startNewWindow(item);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        deleteEvent = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DELETE){
                    Plane planeToDelete = planesListView.getSelectionModel().getSelectedItem();
                    if (planeToDelete != null){
                        planesListView.getItems().remove(planeToDelete);
                        planes.remove(planeToDelete);
                        recalculateStats();
                    }
                }
            }
        };
    }

    public void showPlanesWithRange(){
        if (etFuelFrom.getText().isEmpty() || etFuelTo.getText().isEmpty()){
            // TODO: Alert text is empty
        } else {
            double from = Double.parseDouble(etFuelFrom.getText());
            double to = Double.parseDouble(etFuelTo.getText());

            try {
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource("../view/FuelRange.fxml"));
                Parent root = loader.load();
                Stage newWindow = new Stage();
                FuelRangeController controller = loader.getController();
                controller.planes = planes.stream().filter(x -> x.getFuelConsumption() <= to && x.getFuelConsumption() >= from).toArray(Plane[]::new);
                controller.prepare();
                newWindow.setTitle("Second Stage");
                newWindow.setX(0);
                newWindow.setY(0);
                newWindow.setScene(new Scene(root, 350, 350));
                newWindow.setResizable(false);
                newWindow.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void startNewWindow(Plane plane) throws IOException {
        // Старт нового окна для редактирования
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("../view/AddEditPlane.fxml"));
        Parent root = loader.load();
        Stage newWindow = new Stage();
        AddEditPlane controller = loader.getController();
        controller.parent = this;
        controller.plane = plane;
        controller.prepare();
        newWindow.setTitle("Second Stage");
        newWindow.setX(0);
        newWindow.setY(0);
        newWindow.setScene(new Scene(root, 350, 350));
        newWindow.setResizable(false);
        newWindow.show();
    }

    public void startNewWindow() throws IOException {
        // Старт нового окна
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("../view/AddEditPlane.fxml"));
        Parent root = loader.load();
        Stage newWindow = new Stage();
        AddEditPlane controller = loader.getController();
        controller.parent = this;
        controller.prepare();
        newWindow.setTitle("Second Stage");
        newWindow.setX(0);
        newWindow.setY(0);
        newWindow.setScene(new Scene(root, 350, 350));
        newWindow.setResizable(false);
        newWindow.show();
    }

    public void test(){

    }

    public void save(Plane plane){
        planes.add(plane);
        prepareListView();
        recalculateStats();
    }

    public void prepareListView(){
        Collections.sort(planes, new Comparator<Plane>() {
            @Override
            public int compare(Plane lhs, Plane rhs) {
                // 1 - less than, -1 - greater than, 0 - equal
                if (lhs.getRangeOfFlight() == rhs.getRangeOfFlight())
                    return 0;
                if (lhs.getRangeOfFlight() < rhs.getRangeOfFlight())
                    return 1;
                else
                    return -1;
            }
        });
        planesListView.setItems(null);
        planesListView.setCellFactory(null);
        ObservableList<Plane> observableList = FXCollections.observableArrayList(planes);
        planesListView.setItems(observableList);
        planesListView.setCellFactory(callback);
        planesListView.setOnMouseClicked(doubleClick);
        planesListView.setOnKeyReleased(deleteEvent);
    }

    public void recalculateStats(){

        if (planes.isEmpty()){
            lPassengerTotal.setText("0");
            lWeightTotal.setText("0");
            return;
        }

        double totalWeight = 0.0d;
        int totalPassengers = 0;

        for (Plane p: planes){
            totalWeight += p.getCarryingCapacity();
            totalPassengers += p.getPassengerCapacity();
        }
        lPassengerTotal.setText(Integer.toString(totalPassengers));
        lWeightTotal.setText(Double.toString(totalWeight));
    }
}
