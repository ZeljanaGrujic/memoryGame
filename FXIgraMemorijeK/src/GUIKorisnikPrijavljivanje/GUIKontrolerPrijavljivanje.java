/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIKorisnikPrijavljivanje;

import GUIKorisnikPrijavljivanje.Osluskivaci.OsluskivacPrijaviDK;

import Server_client.GeneralDObject;
import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiKontrolerServer_Service;
import Server_client.GenerickiTransferObjekatKorisnik;
import Server_client.Korisnik;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author user
 */
public class GUIKontrolerPrijavljivanje {

    FXMLDocumentController fxcon;

    GenerickiTransferObjekatKorisnik gto;

    GenerickiKontrolerServer_Service service;
    GenerickiKontrolerServer kal;

    public GUIKontrolerPrijavljivanje(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        this.fxcon = fxcon;

        this.fxcon.prijaviDK.setOnAction(new OsluskivacPrijaviDK(this));

        service = new GenerickiKontrolerServer_Service();
        kal = service.getGenerickiKontrolerServerPort();

        gto = new GenerickiTransferObjekatKorisnik();

    }

    public void poruka(String poruka) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Poruka:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(poruka);
        infoAlert.showAndWait();
    }

    public void prijaviDK() {

        if (svePopunjeno()) {

            Korisnik zaPrijavu = popuniKorisnika();
            gto.setGdo(zaPrijavu);
            System.out.println("Korisnik koji se prijavljuje kor ime: " + gto.getGdo().getKorisnickoIme() + " i sifra: " + gto.getGdo().getSifra());
            pozivSO(nazivSOPrijavi());
            poruka(gto.getTekst().getSadrzaj());
            System.out.println("Prijavljeni korisnik ima ID: " + gto.getTekst().getUlogovaniKorisnik().getIdKorisnik());
        } else {

            poruka("Niste uneli korisnicko ime i/ili sifru!");
        }

    }

    String nazivSOPrijavi() {
        return "prijaviDK";
    }

    public void pozivSO(String nazivSO) {
        if (nazivSO.equals("prijaviDK")) {
            gto = kal.prijaviDK(gto);
        }

    }

    String transferObjekatPoruka() {
        return gto.getTekst().getSadrzaj();
    }

    public GenerickiTransferObjekatKorisnik vratiTransferObjekat() {
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

    public static XMLGregorianCalendar konvertujLocalDateUXMLGregorianCalendar(LocalDate date) {
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar xcal = null;
        try {
            xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException ex) {
            System.out.println("Greska prilikom konvertovanja datuma na klijentskoj strani!" + ex.getLocalizedMessage());
        }
        return xcal;
    }

    private boolean svePopunjeno() {
        String korIme = this.fxcon.korisnickoIme.getText();
        String sifra = this.fxcon.sifra.getText();

        if (!korIme.isEmpty() && !sifra.isEmpty()) {
            return true;
        }
        return false;
    }

    private Korisnik popuniKorisnika() {
        Korisnik kor = new Korisnik();
        kor.setKorisnickoIme(fxcon.korisnickoIme.getText());
        kor.setSifra(fxcon.sifra.getText());
        kor.setDatumRegistracije(konvertujLocalDateUXMLGregorianCalendar(konvertujUtilDateULocalDate(new Date())));

        return kor;
    }

}
