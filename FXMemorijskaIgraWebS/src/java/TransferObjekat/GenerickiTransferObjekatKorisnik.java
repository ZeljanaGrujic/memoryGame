/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObjekat;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Poruka;
import java.io.Serializable;


/**
 *
 * @author user
 */
public class GenerickiTransferObjekatKorisnik implements Serializable {

    public Korisnik gdo;
    public Poruka tekst;
    public boolean signal;
    public String nazivOperacije;

    public void postaviDK(GeneralDObject gdo) {
        this.gdo = (Korisnik) gdo;
    }

    public Poruka vratiPoruka() {
        return tekst;
    }

    public boolean vratiSignal() {

        return this.signal;
    }

    public GeneralDObject vratiDK() {
        return (GeneralDObject) gdo;
    }

    public void postaviNazivOperacije(String nazivOperacije) {
        this.nazivOperacije = nazivOperacije;
    }

    public void postaviSignal(boolean signal) {
        this.signal = signal;
    }

    public void postaviPoruka(Poruka tekst) {
        this.tekst = tekst;
    }

}
