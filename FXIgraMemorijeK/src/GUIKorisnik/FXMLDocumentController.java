package GUIKorisnik;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController {

    @FXML
    public TextField ime;

    @FXML
    public TextField prezime;
    @FXML
    public Button kreirajKorisnika;
    @FXML
    public Button prijaviKorisnika;
    @FXML
    public PasswordField sifra;

    @FXML
    public TextField korisnickoIme;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException {
        GUIKontrolerRegistracija kngui = new GUIKontrolerRegistracija(this);

    }

    public Stage stage;

    void postaviStage(Stage stage) {
        this.stage = stage;
    }

    public void zatvoriFormu() {
        stage.close();
    }

}
