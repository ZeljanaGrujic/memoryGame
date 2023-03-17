/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIGlavniMeni.Osluskivaci;

import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author user
 */
public class OsluskivacMojProfil implements EventHandler{

    GUIGlavniMeni.GUIKontrolerGlavniMeni kongui;

    public OsluskivacMojProfil(GUIGlavniMeni.GUIKontrolerGlavniMeni kongui) {
        this.kongui = kongui;
    }


    @Override
    public void handle(Event t) {

        kongui.prikaziMojProfil();
    }
    
}
