/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIIgrica.Ponasanje;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Partija;
import Server_client.Poruka;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class DodajPartiju extends OpsteIzvrsenjeSO {
    
    //ova klasa ce mi raditi prijavljivanje, kao u primeru RZJFX28

    Partija partija;
    Poruka poruka;

    public boolean dodajPartiju(Partija partija) {
        this.partija = partija;
        return opsteIzvrsenjeSO();
    }

    public Poruka vratiPoruku() {
        return poruka;
    }

    @Override
    public boolean izvrsiSO() {

        this.poruka = new Poruka();
        if (partija == null) {
            poruka.setSadrzaj("Partija nije uspesno dodata u bazu jer je poslati objekat null");
            return false;
        }
        try {
            PreparedStatement ps = bbp.insert(partija);
            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            Long partijaID = tableKeys.getLong(1);

            System.out.println("Partija ima ID: " + partijaID);
            Partija sacuvanaPartija = partija;
            sacuvanaPartija.setIdPartija(partijaID);

            poruka.setSadrzaj("Partija je uspesno ubacena u bazu");

            return true;

        } catch (SQLException ex) {
            System.out.println("DodajPartiju klasa, izvrsiSO dodaj partiju u bazu nije uspesno izvrsena! " + ex.getMessage());
            poruka.setSadrzaj("Partija nije uspesno sacuvana u bazi!");
            return false;
        }

    }

}
