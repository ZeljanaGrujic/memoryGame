/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SO;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Poruka;
import TransferObjekat.GenerickiTransferObjekat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class KreirajDKRegistracija extends OpsteIzvrsenjeSO {

    GenerickiTransferObjekat gto;

    public void kreirajDK(GenerickiTransferObjekat gto) {
        this.gto = gto;
        opsteIzvrsenjeSO();
    }

    @Override
    public boolean izvrsiSO() {
        Poruka p = new Poruka();
        gto.setSignal(false);
        if (gto.getDK() == null) {
            p.setPoruka("Poslati korisnik je null");
            gto.setPoruka(p);
        }
        try {
            PreparedStatement ps = bbp.insert(gto.getDK());
            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            Long korisnikID = tableKeys.getLong(1);
            System.out.println("Korisnik ima ID: " + korisnikID);
            // Korisnik sacuvaniKor = (Korisnik) gto.getDK();
            // sacuvaniKor.setIDKorisnika(korisnikID);

            // gto.setDK(sacuvaniKor);
            p.setPoruka("Korisnik je uspesno ubacen u bazu");
            p.setIdKorisnika(korisnikID);
            // p.ulogovaniKorisnik = sacuvaniKor;

            gto.setPoruka(p);
            gto.setSignal(true);

        } catch (SQLException ex) {
            System.out.println("SO.KKreirajDK.izvrsiSO() nije uspesno izvrsena! " + ex.getMessage());
            p.setPoruka("Korisnik nije uspesno sacuvan u bazi!");
            gto.setPoruka(p);
        }

        return gto.getSignal();
    }
}
