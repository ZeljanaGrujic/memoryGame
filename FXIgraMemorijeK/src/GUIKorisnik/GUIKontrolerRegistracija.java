/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIKorisnik;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Korisnik;
import GUIKorisnik.Osluskivac.OsluskivacKreirajDK;
import GUIKorisnik.Osluskivac.OsluskivacPrijavaKorisnika;
import TransferObjekat.GenerickiTransferObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.scene.control.Alert;

/**
 *
 * @author user
 */
public class GUIKontrolerRegistracija {

    FXMLDocumentController fxcon;
    Socket soket;
    ObjectOutputStream out;
    ObjectInputStream in;

    GenerickiTransferObjekat gto;
    OsluskivacPrijavaKorisnika opk;

    public GUIKontrolerRegistracija(FXMLDocumentController fxcon) throws IOException {
        this.fxcon = fxcon;
        opk = new OsluskivacPrijavaKorisnika(fxcon);

        this.fxcon.kreirajKorisnika.setOnAction(new OsluskivacKreirajDK(this));
        this.fxcon.prijaviKorisnika.setOnAction(opk);

        soket = new Socket("127.0.0.1", 8189);
        gto = new GenerickiTransferObjekat();

    }

    public void poruka(String poruka) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Poruka:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(poruka);
        infoAlert.showAndWait();
    }

    public void kreirajDK() {

        if (svePopunjeno()) {
            Korisnik kor = popuniKorisnika();
            gto.setDK(kor);
            pozivSO(nazivSOKreiraj());
            poruka(gto.getPoruka().getPoruka());
        } else {
            poruka("Sva polja moraju biti popunjena!");
        }
        try {
            System.out.println("Dobijeni Id korisnika iz poruke je: " + gto.getPoruka().getUlogovaniKorisnik().getIDKorisnik());
        } catch (Exception e) {
            System.err.println("Korisnik nije dodat jer vec postoji korisnik sa istim korisnickim imenom i sifrom!");
        }
    }

    private String nazivSOKreiraj() {
        return "kreirajDK";
    }

    public void pozivSO(String nazivSO) {
        gto.setNazivOperacije(nazivSO);
        //Prvo sam kroz konstruktor metode prosledila korisnika koji treba da se setuje
        //Ali kako bi postalo vise genericko onda sam ga sklonila i postavila u konkretnoj metodu kreirajDK
        //System.out.println("Korisnik koji se salje iz metode pozivSO je: " + kor.toString());
        //gto.setDK(kor);

        try {
            out = new ObjectOutputStream(soket.getOutputStream());
            in = new ObjectInputStream(soket.getInputStream());
        } catch (IOException ex) {
            System.err.println("Greska prilikom otvaranja in i/ili out tokova");
        }
        try {
            out.writeObject(gto);
        } catch (IOException ex) {

            System.err.println("Greska prilikm slanja objekta kod out write metode");
        }

        try {
            gto = (GenerickiTransferObjekat) in.readObject();
            System.out.println("Dobijeni TOK objekat nazad je: " + gto.toString());
        } catch (IOException ex) {
            System.err.println("Greska kod ucitavanja objekta in read object metoda" + ex.getStackTrace());
        } catch (ClassNotFoundException ex) {

            System.err.println("Klasa nije pronadjena");
        }
    }

    public LocalDate konvertujUtilDateULocalDate(java.util.Date input) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(sm.format(input));
        LocalDate date = sqlDate.toLocalDate();
        return date;
    }

    public static java.sql.Date konvertujLocalDateUSqlDate(LocalDate input) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = java.sql.Date.valueOf(input);
        return java.sql.Date.valueOf(sm.format(date));
    }

    private boolean svePopunjeno() {
        String korIme = this.fxcon.korisnickoIme.getText();
        String sifra = this.fxcon.sifra.getText();
        String ime = this.fxcon.ime.getText();
        String prezime = this.fxcon.prezime.getText();

        if (!korIme.isEmpty() && !sifra.isEmpty() && !ime.isEmpty() && !prezime.isEmpty()) {
            return true;
        }
        return false;
    }

    private Korisnik popuniKorisnika() {
        Korisnik kor = new Korisnik();
        kor.setKorisnickoIme(fxcon.korisnickoIme.getText());
        kor.setSifra(fxcon.sifra.getText());
        kor.setIme(fxcon.ime.getText());
        kor.setPrezime(fxcon.prezime.getText());
        kor.setDatumRegistracije(konvertujLocalDateUSqlDate(konvertujUtilDateULocalDate(new java.util.Date())));
        return kor;
    }

    //MOZDA MI ZATREBA
    /*  private Poruka transferObjekatPoruka() {

        return gto.getPoruka();
    }

    public GenerickiTransferObjekat vratiTransferObjekat() {
        return gto;
    }
     */
}
