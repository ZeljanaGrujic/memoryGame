package GUIKorisnikPrijavljivanje;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

    @FXML
    public Button prijaviDK;

    @FXML
    public PasswordField sifra;

    @FXML
    public TextField korisnickoIme;

    public GUIKontrolerPrijavljivanje kngui;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        kngui = new GUIKontrolerPrijavljivanje(this);

    }

}
