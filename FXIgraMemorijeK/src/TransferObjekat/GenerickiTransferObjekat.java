/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObjekat;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Poruka;
import java.io.Serializable;


/**
 *
 * @author user
 */
public class GenerickiTransferObjekat implements Serializable {

    public GeneralDObject gdo;
    public Poruka poruka;
    public boolean signal;
    public String nazivOperacije;

    public void setDK(GeneralDObject gdo) {
        this.gdo = gdo;
    }

    public Poruka getPoruka() {
        return poruka;
    }


    public boolean getSignal() {

        return this.signal;
    }

    public GeneralDObject getDK() {
        return this.gdo;
    }

    public void setNazivOperacije(String nazivOperacije) {
        this.nazivOperacije = nazivOperacije;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public void setPoruka(Poruka poruka) {
        this.poruka = poruka;
    }
    
    
}
