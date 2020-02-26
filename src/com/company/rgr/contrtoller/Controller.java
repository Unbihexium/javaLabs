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
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import javafx.event.EventHandler;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {

    Logger logger = Logger.getLogger(this.getClass());

    ArrayList<Plane> planes = new ArrayList<>();
    @FXML
    ListView<Plane> planesListView;

    private Callback<ListView<Plane>, ListCell<Plane>> callback;
    private EventHandler<MouseEvent> doubleClick;

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
                        setText(t.getManufacturer() + " " + t.getModel());
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
    }

    public void mouseClicked(){
        logger.log("Tag", "Message");
        System.out.println(planes.size());
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
    }

    public void prepareListView(){
        planesListView.setItems(null);
        planesListView.setCellFactory(null);
        ObservableList<Plane> observableList = FXCollections.observableArrayList(planes);
        planesListView.setItems(observableList);
        planesListView.setCellFactory(callback);
        planesListView.setOnMouseClicked(doubleClick);
    }

}
