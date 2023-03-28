package GUIGlavniMeni;

import Server_client.Korisnik;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController {

    @FXML
    public Button p50;

    @FXML
    public Button p52;

    @FXML
    public Button p51;

    @FXML
    public Button p10;

    @FXML
    public Button p54;

    @FXML
    public Button p53;

    @FXML
    public Button p12;

    @FXML
    public Button p56;

    @FXML
    public Button p11;

    @FXML
    public Button p55;

    @FXML
    public Button p14;

    @FXML
    public Button p13;

    @FXML
    public Button p57;

    @FXML
    public Button p16;

    @FXML
    public Button p15;

    @FXML
    public Button p17;

    @FXML
    public Button p61;

    @FXML
    public Button p60;

    @FXML
    public Button p63;

    @FXML
    public Button p62;

    @FXML
    public Button p21;

    @FXML
    public Button p65;

    @FXML
    public Button p20;

    @FXML
    public Button p64;

    @FXML
    public Button p23;

    @FXML
    public Button p67;

    @FXML
    public Button p22;

    @FXML
    public Button p66;

    @FXML
    public Button p25;

    @FXML
    public Button p24;

    @FXML
    public Button p27;

    @FXML
    public Button p26;

    @FXML
    public Button p70;

    @FXML
    public Button p72;

    @FXML
    public Button p71;

    @FXML
    public Button p30;

    @FXML
    public Button p74;

    @FXML
    public Button p73;

    @FXML
    public Button p32;

    @FXML
    public Button p76;

    @FXML
    public Button p31;

    @FXML
    public Button p75;

    @FXML
    public Button p34;

    @FXML
    public Button p33;

    @FXML
    public Button p77;

    @FXML
    public Button p36;

    @FXML
    public Button p35;

    @FXML
    public Button p37;

    @FXML
    public Button p41;

    @FXML
    public Button p40;

    @FXML
    public Button p43;

    @FXML
    public Button p42;

    @FXML
    public Button p01;

    @FXML
    public Button p45;

    @FXML
    public Button p00;

    @FXML
    public Button p44;

    @FXML
    public Button p03;

    @FXML
    public Button p47;

    @FXML
    public Button p02;

    @FXML
    public Button p46;

    @FXML
    public Button p05;

    @FXML
    public Button p04;

    @FXML
    public Button p07;

    @FXML
    public Button p06;

    @FXML
    public MenuItem informacije;

    @FXML
    public MenuItem autor;

    @FXML
    public MenuItem knjigePisci;

    @FXML
    public MenuItem razno;

    @FXML
    public MenuItem mojProfil;

    @FXML
    public MenuItem izlaz;

    @FXML
    public void prikaziAutoraIgre() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Informacije o autoru programa:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText("Autor programa: Zeljana Grujic.\n\n" + "Master student, smer: Softversko inženjerstvo i veštačka inteligencija.\n\n" + "Broj indeksa: 3703/2022");
        infoAlert.showAndWait();
    }

    @FXML
    public void izlazIzPrograma() {
        Platform.exit();
        System.exit(0);
    }
    public GUIKontrolerGlavniMeni kngui;

    public Long idKorisnika;
    public Korisnik ulogovaniKor;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        kngui = new GUIKontrolerGlavniMeni(this);

    }

    public Stage stage;

    void postaviStage(Stage stage) {
        this.stage = stage;
    }

    public void zatvoriFormu() {
        stage.close();
    }

    //Ove dve metode mi ne trebaju vec imam ulogovanog korisnika ovde
    public void postaviIDKorisnika(Long id) {
        this.idKorisnika = id;
    }

    public Long vratiIDKorisnika() {
        return idKorisnika;
    }

    public void postaviUlogovanogKorisnika(Korisnik kor) {
        this.ulogovaniKor = kor;
    }

    public Korisnik vratiUlogovanogKorisnika() {
        return ulogovaniKor;
    }
}
