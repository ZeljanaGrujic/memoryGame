/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package Server;

import SO.KPrijaviDK;
import TransferObjekat.GenerickiTransferObjekatKorisnik;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author user
 */
@WebService(serviceName = "GenerickiKontrolerServer")
public class GenerickiKontrolerServer {

    /**
     * This is a sample web service operation
     */
    public GenerickiTransferObjekatKorisnik prijaviDK(GenerickiTransferObjekatKorisnik gto) {
        new KPrijaviDK().prijaviDK(gto);
        return gto;
    }
}
