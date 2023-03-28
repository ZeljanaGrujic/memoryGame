/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIIgrica2.Osluskivaci;

import GUIIgrica1.Osluskivaci.*;
import DomenskiObjekat.Kartica;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author user
 */
public class OsluskivacZatvoriKarticu implements EventHandler {

    Kartica k;
    static Kartica izabranaKartica;

    public OsluskivacZatvoriKarticu(Kartica k, Kartica izabranaKartica) {
        this.k = k;
        this.izabranaKartica = izabranaKartica;
    }

    @Override
    public void handle(Event t) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (izabranaKartica != k && !k.isOkrenuta()) {
            k.zatvori();
        }

    }

}
