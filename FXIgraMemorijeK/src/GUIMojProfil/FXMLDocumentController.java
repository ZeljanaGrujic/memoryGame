package GUIMojProfil;

import GUIKorisnik.*;
import Server_client.Korisnik;
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
    public Button zatvori;
    
    @FXML
    public TextField sifra;
    
    @FXML
    public TextField korisnickoIme;
    
    @FXML
    public TextField idKorisnika;
    
    @FXML
    public TextField datumRegistracije;
    
    public Stage stage;
    
    @FXML
    public void izlazIzPrograma() {
        stage.close();
        
    }

    /* @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException {
        GUIKontrolerRegistracija kngui = new GUIKontrolerRegistracija(this);

    }*/
    void postaviStage(Stage stage) {
        this.stage = stage;
    }
    
    public void zatvoriFormu() {
        stage.close();
    }
    
    void postaviPodatke(Korisnik vratiUlogovanogKorisnika) {
        
        this.idKorisnika.setText(String.valueOf(vratiUlogovanogKorisnika.getIdKorisnik()));
        this.ime.setText(String.valueOf(vratiUlogovanogKorisnika.getIme()));
        this.prezime.setText(String.valueOf(vratiUlogovanogKorisnika.getPrezime()));
        this.datumRegistracije.setText(String.valueOf(vratiUlogovanogKorisnika.getDatumRegistracije()).substring(0, 9));
        this.korisnickoIme.setText(String.valueOf(vratiUlogovanogKorisnika.getKorisnickoIme()));
        this.sifra.setText(String.valueOf(vratiUlogovanogKorisnika.getSifra()));
    }
    
}
