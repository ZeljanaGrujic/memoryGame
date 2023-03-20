/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIKorisnik.Osluskivac;

import GUIKorisnik.GUIKontrolerRegistracija;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author user
 */
public class OsluskivacKreirajDK implements EventHandler{

    GUIKontrolerRegistracija kongui;

    public OsluskivacKreirajDK(GUIKontrolerRegistracija kongui) {
        this.kongui = kongui;
    }


    @Override
    public void handle(Event t) {

        kongui.kreirajDK();
    }
    
}
