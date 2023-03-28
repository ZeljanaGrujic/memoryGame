/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIIgrica2.Osluskivaci;

import GUIIgrica2.Osluskivaci.*;
import DomenskiObjekat.Kartica;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author user
 */
public class OsluskivacOkreniKarticu implements EventHandler {

    Kartica k;
    static Kartica izabranaKartica;
    GUIIgrica2.GUIKontrolerIgrica kongui;

    public OsluskivacOkreniKarticu(Kartica k, Kartica izabranaKartica, GUIIgrica2.GUIKontrolerIgrica kongui) {
        this.kongui = kongui;
        this.k = k;
        this.izabranaKartica = izabranaKartica;
    }

    @Override
    public void handle(Event t) {

        if (k.isOkrenuta()) {
            return;
        }
        if (izabranaKartica != null && !izabranaKartica.isOkrenuta()) {
            if (izabranaKartica != k && izabranaKartica.equals(k)) {
                izabranaKartica.otvori();
                k.otvori();
            } else {
                k.prikaziKarticu();
                izabranaKartica.zatvori();
                izabranaKartica = null;

            }
        } else {
            izabranaKartica = k;
            izabranaKartica.prikaziKarticu();
        }
        if (kongui.sveUpareno()) {
            kongui.poruka("Pobedili ste!");
            kongui.pobeda = 1;

            kongui.fxcon.zatvori.setVisible(true);
        }
    }

}
