/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import DomenskiObjekat.*;
import java.util.List;

/**
 *
 * @author Sinisa
 */
public class ProveraPrijavljivanja extends OpsteIzvrsenjeSO {

    String korisnickoIme;
    String sifra;
    Poruka p;

    public boolean proveraPrijavljivanja(String korisnickoIme, String sifra, Poruka p) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.p = p;
        return opsteIzvrsenjeSO();
    }

    @Override
    public boolean izvrsiSO() {
        Korisnik kor = new Korisnik(korisnickoIme);
        List<GeneralDObject> l = bbp.findRecord(kor, "WHERE korisnickoIme = '" + korisnickoIme + "' and sifra='" + sifra + "'");
        if (l.size() > 0) {
            p.setPoruka("korisnik prijavljen");
            kor = (Korisnik) l.get(0);
            p.setIdKorisnika(kor.getIDKorisnik());
            p.setUlogovaniKorisnik(kor);
        } else {
            p.setPoruka("korisnik nije prijavljen");
        }
        return true;
    }
}
