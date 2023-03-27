/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package GUIIgrica1;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class FXMLDocumentController {

    @FXML
    public GridPane grid;

    @FXML
    public VBox v00;
    @FXML
    public VBox v01;
    @FXML
    public VBox v02;
    @FXML
    public VBox v03;

    @FXML
    public VBox v10;

    @FXML
    public VBox v11;

    @FXML
    public VBox v12;
    @FXML
    public VBox v13;

    @FXML
    public VBox v20;

    @FXML
    public VBox v21;
    @FXML
    public VBox v22;
    @FXML
    public VBox v23;

    @FXML
    public VBox v30;
    @FXML
    public VBox v31;
    @FXML
    public VBox v32;
    @FXML
    public VBox v33;

    public Stage stage;

    public GUIKontrolerIgrica kngui;

    /* @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }*/
    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        kngui = new GUIKontrolerIgrica(this);

    }

    public void postaviStage(Stage stage) {
        this.stage = stage;
    }

    public void zatvoriFormu() {
        stage.close();
    }

    public void postaviSliku() {
        kngui.postaviSlikuNaKarticu();
    }

}
