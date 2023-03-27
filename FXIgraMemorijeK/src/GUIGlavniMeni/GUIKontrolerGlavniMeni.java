/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIGlavniMeni;

import GUIGlavniMeni.Osluskivaci.OsluskivacMojProfil;
import GUIGlavniMeni.Osluskivaci.OsluskivacPesniciPisci;
import GUIGlavniMeni.Osluskivaci.OsluskivacPravilaIgre;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Sinisa
 */
public class GUIKontrolerGlavniMeni {

    FXMLDocumentController fxcon;
    int mat[][];

    public GUIKontrolerGlavniMeni(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.fxcon = fxcon;
        obojiGlavniMeni();
        // Glavni meni: 
        // 1. Pravila igre
        // 1.1 Pogledaj pravila igre
        //1.2 Autor programa metoda je definisana u FXMLDocumentControlleru zbog propertija setOnAction
        this.fxcon.informacije.setOnAction(new OsluskivacPravilaIgre(this));

        // 2. Pokreni igru
        // 2.1 Pesnici pisci
        this.fxcon.knjigePisci.setOnAction(new OsluskivacPesniciPisci(this));
        //2.2 Razno
        // 3. Moj profil
        // 3.1 Moj profil
        this.fxcon.mojProfil.setOnAction(new OsluskivacMojProfil(this));
        // 4. Izlaz iz programa
        // 4.1 Izlaz metoda je definisana u FXMLDocumentControlleru zbog propertija setOnAction
        //postavljanje boja na glavni meni
    }

    void obojiGlavniMeni() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                try {
                    postaviBoje(x, y);
                    postaviNaslov(x, y);
                } catch (NoSuchFieldException ex) {
                    System.err.println("Nije pronadjeno specificirano polje u GUIKontrolerGlavniMeni klasi" + ex.getStackTrace());
                } catch (IllegalArgumentException ex) {
                    System.err.println("Nisu prosledjeni ocekivani argumenti u GUIKontrolerGlavniMeni klasi" + ex.getStackTrace());
                } catch (IllegalAccessException ex) {
                    System.err.println("Nedozvoljen pristup u GUIKontrolerGlavniMeni klasi" + ex.getStackTrace());
                }

            }
        }
    }

    // 1.1 Start
    //1.1 Pravila igre
    public void prikaziPravilaIgre() {
        try {
            System.out.println("Ovo su pravila igre");
            GUIPravilaIgre.JFX04 jfx04;
            Stage s;
            jfx04 = new GUIPravilaIgre.JFX04();
            s = new Stage();
            jfx04.start(s);
        } catch (Exception ex) {
            System.err.println("Greska prilikom pozivanja pravila igre u GUIKontrolerGlavniMeni " + ex.getStackTrace());
        }

    }

    public void prikaziIgruPesniciPisci() {

        GUIIgrica1.JFX06 jfx06;
        GUIIgrica1.FXMLDocumentController igrCon;
        Stage s;

        jfx06 = new GUIIgrica1.JFX06();
        igrCon = jfx06.getController();

        s = new Stage();

        try {
            //jfx06.start(cn.postaviTalon());
            jfx06.start(s);
        } catch (Exception ex) {
            System.err.println("Greska u metodi GuiKontrolerGlavniMeni prilikom odabira Pisci iz padajuceg menija");

        }
    }

    public void prikaziMojProfil() {

        try {
            //System.out.println("ID ulogovanog korisnika u Glavni Meni kontroleru je: " + this.fxcon.vratiIDKorisnika());
            System.out.println("ID ulogovanog korisnika u Glavni Meni kontroleru, izvucen iz celog objekta je: " + this.fxcon.vratiIDKorisnika());

            GUIMojProfil.JFX05 jfx05;
            Stage s;
            jfx05 = new GUIMojProfil.JFX05();
            s = new Stage();
            jfx05.start(s);
            jfx05.postaviPodatke(this.fxcon.vratiUlogovanogKorisnika());
        } catch (Exception ex) {
            System.err.println("Greska u GUIKontrolerGlavniMeni, metoda prikazi moj profil" + ex.getStackTrace());
        }

    }

    public void poruka(String poruka) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Poruka:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(poruka);
        infoAlert.showAndWait();
    }

    public void postaviBoje(int x, int y) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        String nazivDugmeta = "p" + x + y;
        Class cls = this.fxcon.getClass();
        Field field = cls.getDeclaredField(nazivDugmeta);
        Button b = (Button) field.get(this.fxcon);
        if (x == 0) {
            b.getStyleClass().add("crveno-polje");
        }
        if (x == 1) {
            b.getStyleClass().add("narandzasto-polje");
        }
        if (x == 2) {
            b.getStyleClass().add("zuto-polje");
        }
        if (x == 3) {
            b.getStyleClass().add("roze-polje");
        }
        if (x == 4) {
            b.getStyleClass().add("ljubicasto-polje");
        }
        if (x == 5) {
            b.getStyleClass().add("plavo-polje");
        }
        if (x == 6) {
            b.getStyleClass().add("zeleno-polje");
        }
        if (x == 7) {
            b.getStyleClass().add("sivo-polje");
        }
    }

    public void postaviNaslov(int x, int y) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        String nazivDugmeta = "p" + x + y;
        Class cls = this.fxcon.getClass();
        Field field = cls.getDeclaredField(nazivDugmeta);
        Button b = (Button) field.get(this.fxcon);

        if (x == 3 && y == 2) {
            b.getStyleClass().add("slovo-i");
        }
        if (x == 3 && y == 3) {
            b.getStyleClass().add("slovo-g");
        }
        if (x == 3 && y == 4) {
            b.getStyleClass().add("slovo-r");
        }
        if (x == 3 && y == 5) {
            b.getStyleClass().add("slovo-a");
        }
        if (x == 4 && y == 0) {
            b.getStyleClass().add("slovo-m");
        }
        if (x == 4 && y == 1) {
            b.getStyleClass().add("slovo-e");
        }
        if (x == 4 && y == 2) {
            b.getStyleClass().add("slovo-m");
        }
        if (x == 4 && y == 3) {
            b.getStyleClass().add("slovo-o");
        }
        if (x == 4 && y == 4) {
            b.getStyleClass().add("slovo-r");
        }
        if (x == 4 && y == 5) {
            b.getStyleClass().add("slovo-i");
        }
        if (x == 4 && y == 6) {
            b.getStyleClass().add("slovo-j");
        }
        if (x == 4 && y == 7) {
            b.getStyleClass().add("slovo-e");
        }
    }

}
