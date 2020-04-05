package com.company.rgr.contrtoller;

import com.company.rgr.model.AbstractPlane;
import com.company.rgr.model.CargoPlane;
import com.company.rgr.model.FireFighterPlane;
import com.company.rgr.model.PassengerPlane;
import com.company.rgr.utils.Logger;
import com.company.rgr.utils.PlaneTypes;
import javafx.application.Platform;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Controller {

    Logger logger = Logger.getLogger(this.getClass());

    ArrayList<AbstractPlane> planes = new ArrayList<>();
    @FXML
    ListView<AbstractPlane> planesListView;

    @FXML
    Label lWeightTotal, lPassengerTotal, lCrewTotal;

    @FXML
    TextField etFuelFrom, etFuelTo;

    @FXML
    ChoiceBox<PlaneTypes> planeType;

    private Callback<ListView<AbstractPlane>, ListCell<AbstractPlane>> callback;
    private EventHandler<MouseEvent> doubleClick;
    private EventHandler<KeyEvent> deleteEvent;

    public Controller() {
        callback = new Callback<ListView<AbstractPlane>, ListCell<AbstractPlane>>() {
            @Override
            public ListCell<AbstractPlane> call(ListView<AbstractPlane> planeListView) {
                ListCell<AbstractPlane> cell = new ListCell<AbstractPlane>() {
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
                return cell;
            }
        };

        doubleClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    AbstractPlane item = null;
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

        deleteEvent = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DELETE) {
                    AbstractPlane planeToDelete = planesListView.getSelectionModel().getSelectedItem();
                    if (planeToDelete != null) {
                        planesListView.getItems().remove(planeToDelete);
                        planes.remove(planeToDelete);
                        logger.log("Удален самолет");
                        recalculateStats();
                    }
                }
            }
        };
    }

    @FXML
    public void initialize() {
        planeType.setItems(FXCollections.observableArrayList(PlaneTypes.values()));
        planeType.setValue(PlaneTypes.CARGO);
    }

    public void showPlanesWithRange() {
        if (etFuelFrom.getText().isEmpty() || etFuelTo.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверные данные");
            alert.setContentText("Поля ввода пусты");

            alert.showAndWait();
        } else {
            try {
                double from = Double.parseDouble(etFuelFrom.getText());
                double to = Double.parseDouble(etFuelTo.getText());

                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource("../view/RangeOfFlightView.fxml"));
                Parent root = loader.load();
                Stage newWindow = new Stage();
                RangeOfFlightController controller = loader.getController();

                // Жесть
                Object[] objects  = this.planes.stream().filter(x -> x.getRangeOfFlight() <= to && x.getRangeOfFlight() >= from).toArray();
                AbstractPlane[] planes = new AbstractPlane[objects.length];

                for (int i = 0; i < objects.length; ++i){
                    if (objects[i] instanceof PassengerPlane) {
                        planes[i] = (PassengerPlane) objects[i];
                    } else if (objects[i] instanceof CargoPlane) {
                        planes[i] = (CargoPlane) objects[i];
                    } else if (objects[i] instanceof FireFighterPlane) {
                        planes[i] = (FireFighterPlane) objects[i];
                    }
                }
                controller.planes = planes;
                controller.prepare();
                newWindow.setTitle("Самолеты с заданной дальностью полета");
                newWindow.setX(0);
                newWindow.setY(0);
                newWindow.setScene(new Scene(root, 350, 350));
                newWindow.setResizable(false);
                newWindow.show();
                logger.log("Показано окно c самолетами с дальностью полета от:" + from + " до: " + to);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                logger.log("Ошибка при вводе данных");
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Ошибка");
                alert.setHeaderText("Неверные данные");
                alert.setContentText("В поля ввода необходимо ввести вещественные числа");

                alert.showAndWait();
            }

        }
    }

    public void startNewWindow(AbstractPlane plane) throws IOException {
        // Старт нового окна
        FXMLLoader loader = new FXMLLoader();
        Stage newWindow = new Stage();
        String logmsg = "";
        if (plane instanceof PassengerPlane) {
            loader.setLocation(getClass().getResource("../view/PassengerPlaneView.fxml"));
            newWindow.setTitle("Пассажирский самолет");
            logmsg = "Показано окно редактирования пассажирского самолета";
        } else if (plane instanceof CargoPlane) {
            loader.setLocation(getClass().getResource("../view/CargoPlaneView.fxml"));
            newWindow.setTitle("Грузовой самолет");
            logmsg = "Показано окно редактирования грузового самолета";
        } else if (plane instanceof FireFighterPlane) {
            loader.setLocation(getClass().getResource("../view/FireFighterView.fxml"));
            newWindow.setTitle("Пожарный самолет");
            logmsg = "Показано окно редактирования пожарного самолета";
        }

        Parent root = loader.load();

        BasePlaneController controller = loader.getController();
        controller.controller = this;
        if (plane instanceof PassengerPlane) {
            ((PassengerPlaneController) controller).plane = (PassengerPlane) plane;
            ((PassengerPlaneController) controller).initialize();
        } else if (plane instanceof CargoPlane) {
            ((CargoPlaneController) controller).plane = (CargoPlane) plane;
            ((CargoPlaneController) controller).initialize();
        } else if (plane instanceof FireFighterPlane) {
            ((FireFighterController) controller).plane = (FireFighterPlane) plane;
            ((FireFighterController) controller).initialize();
        }

        newWindow.setX(0);
        newWindow.setY(0);
        newWindow.setScene(new Scene(root, 600, 400));
        newWindow.setResizable(false);
        newWindow.show();
        logger.log(logmsg);
    }

    public void startNewWindow() throws IOException {
        // Старт нового окна
        FXMLLoader loader = new FXMLLoader();
        Stage newWindow = new Stage();
        String logmsg = "";
        switch (this.planeType.getValue()) {
            case CARGO:
                loader.setLocation(getClass().getResource("../view/CargoPlaneView.fxml"));
                newWindow.setTitle("Новый грузовой самолет");
                logmsg = "Показано окно добавления грузового самолета";
                break;
            case PASSENGER:
                loader.setLocation(getClass().getResource("../view/PassengerPlaneView.fxml"));
                newWindow.setTitle("Новый пассажирский самолет");
                logmsg = "Показано окно добавления пассажирского самолета";
                break;
            case FIREFIGHTER:
                loader.setLocation(getClass().getResource("../view/FireFighterView.fxml"));
                newWindow.setTitle("Новый пожарный самолет");
                logmsg = "Показано окно добавления пожарного самолета";
                break;
        }
        Parent root = loader.load();

        BasePlaneController controller = loader.getController();
        controller.controller = this;

        newWindow.setX(0);
        newWindow.setY(0);
        newWindow.setScene(new Scene(root, 600, 400));
        newWindow.setResizable(false);
        newWindow.show();
        logger.log(logmsg);
    }

    public void save(AbstractPlane plane) {
        planes.add(plane);
        prepareListView();
        recalculateStats();
    }

    public void prepareListView() {
        Collections.sort(planes, new Comparator<AbstractPlane>() {
            @Override
            public int compare(AbstractPlane lhs, AbstractPlane rhs) {
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
        ObservableList<AbstractPlane> observableList = FXCollections.observableArrayList(planes);
        planesListView.setItems(observableList);
        planesListView.setCellFactory(callback);
        planesListView.setOnMouseClicked(doubleClick);
        planesListView.setOnKeyReleased(deleteEvent);
        logger.log("Обновлен ListView с самолетами");
    }

    public void recalculateStats() {

        if (planes.isEmpty()) {
            lPassengerTotal.setText("0");
            lWeightTotal.setText("0");
            lCrewTotal.setText("0");
            return;
        }

        double totalWeight = 0.0d;
        int totalPassengers = 0;
        int totalCrew = 0;

        for (AbstractPlane plane: planes){
            if (plane instanceof PassengerPlane) {
                PassengerPlane p = (PassengerPlane) plane;
                totalWeight += p.getCarryingCapacity();
                totalPassengers += p.getPassengers();
                totalCrew += p.getCrew();
            } else if (plane instanceof CargoPlane) {
                CargoPlane p = (CargoPlane) plane;
                totalWeight += p.getCarryingCapacity();
                totalCrew += p.getCrew();
            } else if (plane instanceof FireFighterPlane) {
                FireFighterPlane p = (FireFighterPlane) plane;
                totalWeight += p.getWaterCapacity();
                totalCrew += p.getCrew();
            }
        }
        lPassengerTotal.setText(Integer.toString(totalPassengers));
        lWeightTotal.setText(Double.toString(totalWeight));
        lCrewTotal.setText(Integer.toString(totalCrew));
        logger.log("Пересчитана статистика");
    }

    public void save(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Pictures");

        // Set Initial Directory
        fileChooser.setInitialDirectory(new File("/Users/ednalobin/Documents/"));

        File contents = fileChooser.showSaveDialog(this.planesListView.getScene().getWindow());
        logger.log("Показано окно выбора пути сохранения");
        if (contents != null) {
            contents = new File(contents.getAbsolutePath() + ".parc");
            try {
                logger.log("Начато сохранение");
                writeToFile(contents);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void writeToFile(File f) throws FileNotFoundException {
        logger.log("Создан фоновый поток для сохранения");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PrintWriter writer = new PrintWriter(f);
                    for (AbstractPlane plane : planes) {
                        if (plane instanceof PassengerPlane) {
                            PassengerPlane p = (PassengerPlane) plane;
                            StringBuilder bld = new StringBuilder();
                            bld.append("P;");
                            bld.append(p.getModel());
                            bld.append(";");
                            bld.append(p.getManufacturer());
                            bld.append(";");
                            bld.append(p.getCrew());
                            bld.append(";");
                            bld.append(p.getRangeOfFlight());
                            bld.append(";");
                            bld.append(p.getCarryingCapacity());
                            bld.append(";");
                            bld.append(p.getPassengers());
                            bld.append("\n");
                            writer.write(bld.toString());
                            continue;
                        }
                        if (plane instanceof CargoPlane) {
                            CargoPlane p = (CargoPlane) plane;
                            StringBuilder bld = new StringBuilder();
                            bld.append("C;");
                            bld.append(p.getModel());
                            bld.append(";");
                            bld.append(p.getManufacturer());
                            bld.append(";");
                            bld.append(p.getCrew());
                            bld.append(";");
                            bld.append(p.getRangeOfFlight());
                            bld.append(";");
                            bld.append(p.getCarryingCapacity());
                            bld.append("\n");
                            writer.write(bld.toString());
                            continue;
                        }
                        if (plane instanceof FireFighterPlane) {
                            FireFighterPlane p = (FireFighterPlane) plane;
                            StringBuilder bld = new StringBuilder();
                            bld.append("F;");
                            bld.append(p.getModel());
                            bld.append(";");
                            bld.append(p.getManufacturer());
                            bld.append(";");
                            bld.append(p.getCrew());
                            bld.append(";");
                            bld.append(p.getRangeOfFlight());
                            bld.append(";");
                            bld.append(p.getWaterCapacity());
                            bld.append("\n");
                            writer.write(bld.toString());
                            continue;
                        }
                    }

                    writer.close();
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        logger.log("Сохранение завершено");
                        logger.log("Поток останавливается");
                    }
                });
            }
        });
        logger.log("Запущен фоновый поток");
        thread.start();
    }

    public void load(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Pictures");

        // Set Initial Directory
        fileChooser.setInitialDirectory(new File("/Users/ednalobin/Documents/"));

        // Add Extension Filters
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PArc", "*.parc"));

        File contents = fileChooser.showOpenDialog(this.planesListView.getScene().getWindow());
        System.out.println(contents);
        try {
            ArrayList<AbstractPlane> planes;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        var buf = loadFromFile(contents);

                        Runnable updater = new Runnable() {

                            @Override
                            public void run() {
                                logger.log("Получение данных из фонового потока");
                                getResultFromBackground(buf);
                                prepareListView();
                                recalculateStats();
                                logger.log("Остановка фонового потока");
                            }
                        };
                        Platform.runLater(updater);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            logger.log("Создан фоновый поток для загрузки");
            thread.start();
            logger.log("Запущен фоновый поток");
        } catch (Exception e){
            e.printStackTrace();
        }
        prepareListView();
        recalculateStats();
    }

    public void getResultFromBackground(ArrayList<AbstractPlane> planes){
        if (planes != null) {
            this.planes = planes;
            logger.log("Данные загружены");
        }
    }

    public ArrayList<AbstractPlane> loadFromFile(File file) throws IOException {
        var planes = new ArrayList<AbstractPlane>();
        var lines = Files.readAllLines(Path.of(String.valueOf(file)));
        for (String l: lines){
            var split = l.split(";");
            switch (split[0]){
                case "P":
                    PassengerPlane pp = new PassengerPlane();
                    pp.setModel(split[1]);
                    pp.setManufacturer(split[2]);
                    pp.setCrew(Integer.parseInt(split[3]));
                    pp.setRangeOfFlight(Double.parseDouble(split[4]));
                    pp.setCarryingCapacity(Double.parseDouble(split[5]));
                    pp.setPassengers(Integer.parseInt(split[6]));
                    planes.add(pp);
                    break;
                case "C":
                    CargoPlane cp = new CargoPlane();
                    cp.setModel(split[1]);
                    cp.setManufacturer(split[2]);
                    cp.setCrew(Integer.parseInt(split[3]));
                    cp.setRangeOfFlight(Double.parseDouble(split[4]));
                    cp.setCarryingCapacity(Double.parseDouble(split[5]));
                    planes.add(cp);
                    break;
                case "F":
                    FireFighterPlane fp = new FireFighterPlane();
                    fp.setModel(split[1]);
                    fp.setManufacturer(split[2]);
                    fp.setCrew(Integer.parseInt(split[3]));
                    fp.setRangeOfFlight(Double.parseDouble(split[4]));
                    fp.setWaterCapacity(Double.parseDouble(split[5]));
                    planes.add(fp);
                    break;

            }
        }
        if (!planes.isEmpty())
            return planes;
        else
            return null;
    }
}
