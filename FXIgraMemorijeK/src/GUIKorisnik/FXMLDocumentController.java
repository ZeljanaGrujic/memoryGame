package GUIKorisnik;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

    @FXML
    public TextField ime;

    @FXML
    public TextField prezime;
    @FXML
    public Button kreirajKorisnika;
    @FXML
    public PasswordField sifra;

    @FXML
    public TextField korisnickoIme;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException {
        GUIKontrolerRegistracija kngui = new GUIKontrolerRegistracija(this);

    }

}
