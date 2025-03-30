package com.david.listclassfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class HelloController {
    @FXML
    public Label welcomeText;
    @FXML
    private TableColumn<DirClass, String> ColConstructores;
    @FXML
    private TableColumn<DirClass, String> ColMethods;
    @FXML
    private TableColumn<DirClass, String> ColAtributos;
    @FXML
    private TableView<DirClass> tablaDatos;
    @FXML
    private VBox rootVbox;
    @FXML
    private AnchorPane anchoPanel;
    @FXML
    private TextField CampoClassBuscar;
    @FXML
    private Button BotonBuscar;

    @FXML
    private void initialize() throws ClassNotFoundException {
        // Se asume que en DirClass los getters se llaman getConstructors, getMethodsAsString y getAtributos.
        ColConstructores.setCellValueFactory(new PropertyValueFactory<>("constructors"));
        ColMethods.setCellValueFactory(new PropertyValueFactory<>("methodsAsString"));
        ColAtributos.setCellValueFactory(new PropertyValueFactory<>("atributos"));

        CampoClassBuscar.setText("java.lang.String");

        ObservableList<DirClass> elements = FXCollections.observableArrayList(
                new DirClass("java.lang.String")
        );
        tablaDatos.setItems(elements);
    }

    public void onActionBotonBuscar(ActionEvent actionEvent) {
        try {
            ObservableList<DirClass> datos = tablaDatos.getItems();
            datos.add(new DirClass(CampoClassBuscar.getText()));
            tablaDatos.setItems(datos);
        } catch (ClassNotFoundException e) {
            VBox p = new VBox();
            p.setAlignment(Pos.CENTER);
            p.setPadding(new Insets(10));
            Label l = new Label("Alerta, la clase " + CampoClassBuscar.getText() + " No existe");
            p.getChildren().add(l);
            Scene alertWindows = new Scene(p);
            Stage stage = new Stage();
            stage.setTitle("Alerta");
            stage.setScene(alertWindows);
            stage.show();

        }

    }

    public void OnActionLimpiar(ActionEvent actionEvent) {
        tablaDatos.setItems(FXCollections.observableArrayList());
    }
}
