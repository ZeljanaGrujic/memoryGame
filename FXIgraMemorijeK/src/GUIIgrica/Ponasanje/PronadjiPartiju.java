/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIIgrica.Ponasanje;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Partija;
import Server_client.Poruka;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class PronadjiPartiju extends OpsteIzvrsenjeSO {

    //ova klasa ce mi raditi prijavljivanje, kao u primeru RZJFX28
    Partija partija;
    Poruka poruka;
    List<GeneralDObject> l;

    public boolean pronadjiPartiju(Long idKorisnik, int idIgrica) {
        partija = new Partija();
        partija.setIdKorisnik(idKorisnik);
        partija.setIdIgrica(idIgrica);
        return opsteIzvrsenjeSO();
    }

    public Poruka vratiPoruku() {
        return poruka;
    }

    @Override
    public boolean izvrsiSO() {

        l = new ArrayList<>();
        this.poruka = new Poruka();
        if (partija.getIdKorisnik() == null) {
            poruka.setSadrzaj("Ne mogu se pronaci partije za korisnika jer je poslati objekat null");
            return false;
        }
        try {

            l = bbp.findRecord(partija,
                    " WHERE idKorisnik=" + partija.getIdKorisnik() + " AND idIgrica=" + partija.getIdIgrica() + " ORDER BY datumIgranja DESC");
            poruka.setSadrzaj("Partije su uspesno pronadjene iz baze!");
            postaviListuPartija(l);

            return true;

        } catch (Exception ex) {
            System.out.println("DodajPartiju klasa, izvrsiSO dodaj partiju u bazu nije uspesno izvrsena! " + ex.getMessage());
            poruka.setSadrzaj("Partija nije uspesno sacuvana u bazi!");
            return false;
        }

    }

    private void postaviListuPartija(List<GeneralDObject> l) {

        this.l = l;
    }

    public List<GeneralDObject> vratiListuPartija() {
        return this.l;
    }

}
