package GUIMojProfil;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Partija;
import GUIIgrica.Ponasanje.PronadjiPartiju;
import GUIKorisnik.*;
import Server_client.Korisnik;
import java.io.IOException;
import java.util.List;
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
    public TextField nivo1;

    @FXML
    public TextField nivo2;

    @FXML
    public TextField datumNivo1;

    @FXML
    public TextField datumNivo2;

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

        Long idKorisnik = vratiUlogovanogKorisnika.getIdKorisnik();
        postaviPodatkeAktivnosti(idKorisnik);

    }

    private void postaviPodatkeAktivnosti(Long idKorisnik) {

        PronadjiPartiju pp = new PronadjiPartiju();
        if (pp.pronadjiPartiju(idKorisnik, 1)) {
            List<GeneralDObject> partije1 = pp.vratiListuPartija();
            if (partije1.size() > 0) {
                this.nivo1.setText(String.valueOf(partije1.size()));
                Partija p = (Partija) partije1.get(0);
                this.datumNivo1.setText(String.valueOf(p.getDatumIgranja()));
            } else {
                this.nivo1.setText(String.valueOf(0));
                this.datumNivo1.setText("");
            }
        }

        if (pp.pronadjiPartiju(idKorisnik, 2)) {
            List<GeneralDObject> partije2 = pp.vratiListuPartija();
            if (partije2.size() > 0) {
                this.nivo2.setText(String.valueOf(partije2.size()));
                //vracaju mi se sortirane partije po datumu, tako da je prvi rekord zapravo poslednja odigrana igra tog korisnika
                Partija p = (Partija) partije2.get(0);
                this.datumNivo2.setText(String.valueOf(p.getDatumIgranja()));
            } else {
                this.nivo2.setText(String.valueOf(0));
                this.datumNivo2.setText("");
            }
        }

    }

}
