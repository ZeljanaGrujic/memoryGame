package TransferObjekat;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Poruka;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author user
 */
public class GenerickiTransferObjekatKorisnik implements Serializable {

    public Korisnik kor;
    public Poruka poruka;
    public boolean signal;
    public String nazivOperacije;

    public void postaviDK(Korisnik kor) {
        this.kor = kor;
    }

    public Poruka vratiPoruka() {
        return poruka;
    }

    public boolean vratiSignal() {

        return this.signal;
    }

    public Korisnik vratiDK() {
        return this.kor;
    }

    public void postaviNazivOperacije(String nazivOperacije) {
        this.nazivOperacije = nazivOperacije;
    }

    public void postaviSignal(boolean signal) {
        this.signal = signal;
    }

    public void postaviPoruka(Poruka poruka) {
        this.poruka = poruka;
    }

}
