/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIIgrica1.Osluskivaci;

import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author user
 */
public class OsluskivacPocni implements EventHandler {

    GUIIgrica1.GUIKontrolerIgrica kongui;

    public OsluskivacPocni(GUIIgrica1.GUIKontrolerIgrica kongui) {
        this.kongui = kongui;
    }

    @Override
    public void handle(Event t) {

        kongui.pocni();
    }

}
