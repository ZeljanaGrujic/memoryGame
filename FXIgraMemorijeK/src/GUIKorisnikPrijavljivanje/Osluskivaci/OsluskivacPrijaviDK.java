/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIKorisnikPrijavljivanje.Osluskivaci;

import GUIKorisnikPrijavljivanje.GUIKontrolerPrijavljivanje;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author user
 */
public class OsluskivacPrijaviDK implements EventHandler {

    GUIKontrolerPrijavljivanje kongui;

    public OsluskivacPrijaviDK(GUIKontrolerPrijavljivanje kongui) {
        this.kongui = kongui;
    }

    @Override
    public void handle(Event event) {
        kongui.prijaviDK();
    }
}
