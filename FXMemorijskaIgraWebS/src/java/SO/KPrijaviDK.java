/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Poruka;
import static SO.OpsteIzvrsenjeSO.bbp;
import TransferObjekat.GenerickiTransferObjekatKorisnik;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class KPrijaviDK extends OpsteIzvrsenjeSO {

    GenerickiTransferObjekatKorisnik gto;

    public void prijaviDK(GenerickiTransferObjekatKorisnik gto) {
        this.gto = gto;
        opsteIzvrsenjeSO();
    }

    @Override
    public boolean izvrsiSO() {

        Poruka p = new Poruka();
        List<GeneralDObject> l = new ArrayList<>();
        gto.signal = false;

        Korisnik k = (Korisnik) gto.vratiDK();
        System.out.println("Korisnicko ime za prijavu sa web servisa: " + k.getKorisnickoIme() + " sifra za prijavu sa web servisa: " + k.getSifra());
        if (gto.vratiDK() == null) {
            p.setSadrzaj("Poslati korisnik za prijavu je null");
            gto.postaviPoruka(p);
        }

        try {
            l = bbp.findRecord(gto.gdo,
                    " WHERE korisnickoIme='" + gto.gdo.getKorisnickoIme() + "' AND sifra='" + gto.gdo.getSifra() + "'");

        } catch (Exception e) {
            System.err.println("Greska kod pronalaska korisnika u bazi kod WEB servisa a poruka je: " + e.getLocalizedMessage());
        }

        if (l.size() > 0) {
            p.setSadrzaj("korisnik prijavljen");
            Korisnik kor = (Korisnik) l.get(0);
            p.setIdKorisnika(kor.getIDKorisnik());
            p.setUlogovaniKorisnik(kor);
            gto.postaviPoruka(p);
            gto.postaviSignal(true);
        } else {
            p.setSadrzaj("korisnik nije uspesno prijavljen");
            gto.postaviPoruka(p);
        }

        return gto.signal;
    }
}
