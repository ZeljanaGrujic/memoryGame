/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIKorisnik;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Poruka;
import GUIKorisnik.Osluskivac.OsluskivacKreirajDK;
import TransferObjekat.GenerickiTransferObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.invoke.MethodHandles;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Korisnik kor;

    public GUIKontrolerRegistracija(FXMLDocumentController fxcon) throws IOException {
        this.fxcon = fxcon;

        this.fxcon.kreirajKorisnika.setOnAction(new OsluskivacKreirajDK(this));

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

        kor = new Korisnik();
        kor.setKorisnickoIme(fxcon.korisnickoIme.getText());
        kor.setSifra(fxcon.sifra.getText());
        kor.setIme(fxcon.ime.getText());
        kor.setPrezime(fxcon.prezime.getText());
        kor.setDatumRegistracije(konvertujLocalDateUSqlDate(konvertujUtilDateULocalDate(new java.util.Date())));
        System.out.println("Datum kreiranja korisnika je: " + kor.getDatumRegistracije());
        System.out.println("Korisnik koji se salje je: " + kor.toString());
        pozivSO(nazivSOKreiraj(), kor);
       // Poruka p = transferObjekatPoruka();
        poruka(gto.getPoruka().getPoruka());
        System.out.println("Dobijeni Id korisnika iz poruke je: "+gto.getPoruka().getIdKorisnika());
        // Korisnik sacuvaniKor = (Korisnik) gto.getDK();
        // System.out.println("Sacuvani korisnik je: " + sacuvaniKor.getIme() + " sa ID jem: " + sacuvaniKor.getIDKorisnik());
        //  System.out.println("Vraceni korisnik iz TOK objekta je na adresi "+sacuvaniKor);

    }

    private String nazivSOKreiraj() {
        return "kreirajDK";
    }

    public void pozivSO(String nazivSO, Korisnik kor) {
        gto.setNazivOperacije(nazivSO);
        System.out.println("Korisnik koji se salje iz metode pozivSO je: " + kor.toString());
        gto.setDK(kor);

        try {
            out = new ObjectOutputStream(soket.getOutputStream());
            in = new ObjectInputStream(soket.getInputStream());
        } catch (IOException ex) {
            System.err.println("Greska prilikom otvaranja in i out tokova");
        }
        try {
            out.writeObject(gto);
        } catch (IOException ex) {

            System.err.println("Greska prilikm slanja objekta kod out write");
        }

        try {
            gto = (GenerickiTransferObjekat) in.readObject();
            System.out.println("Dobijeni TOK objekat nazad je: " + gto.toString());
        } catch (IOException ex) {
            System.err.println("Greska kod ucitavanja objekta in read object" + ex.getStackTrace());
        } catch (ClassNotFoundException ex) {

            System.err.println("Klasa nije pronadjena");
        }
    }

    private Poruka transferObjekatPoruka() {

        return gto.getPoruka();
    }

    public GenerickiTransferObjekat vratiTransferObjekat() {
        return gto;
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

}
