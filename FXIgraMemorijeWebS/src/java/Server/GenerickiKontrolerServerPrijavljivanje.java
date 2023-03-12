/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package Server;

import SO.ProveraPrijavljivanja;
import TransferObjekat.GenerickiTransferObjekatKorisnik;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author user
 */
@WebService(serviceName = "GenerickiKontrolerServerPrijavljivanje")
public class GenerickiKontrolerServerPrijavljivanje {

    /**
     * This is a sample web service operation
     */
    public GenerickiTransferObjekatKorisnik proveraPrijavljivanja(GenerickiTransferObjekatKorisnik gto) {
        new ProveraPrijavljivanja().proveraPrijavljivanja(gto.vratiDK().getKorisnickoIme(), gto.vratiDK().getSifra(), gto.vratiPoruka());
        return gto;
    }
}
