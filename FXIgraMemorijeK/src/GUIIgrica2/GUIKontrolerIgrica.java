/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIIgrica2;

import GUIIgrica2.*;
import DomenskiObjekat.Kartica;
import GUIIgrica2.Osluskivaci.OsluskivacOkreniKarticu;
import GUIIgrica2.Osluskivaci.OsluskivacPocni;
import GUIIgrica1.Osluskivaci.OsluskivacZatvoriKarticu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.smartcardio.Card;

/**
 *
 * @author user
 */
public class GUIKontrolerIgrica {

    public FXMLDocumentController fxcon;
    List<Kartica> kartice;
    static Kartica izabranaKartica;

    //GridPane rootSceene = new GridPane();
    //VBox box = new VBox();
    public GUIKontrolerIgrica(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        this.fxcon = fxcon;
        try {
            postaviTalonForma();
            // vratiTalon();
            // postaviSlikuNaKarticu();
        } catch (Exception e) {
            System.err.println("Greska u GUIKotroler konstruktoru kod postavljanja kartica" + e.getLocalizedMessage());
        }
        // postaviTalon();
        // this.fxcon.button.setOnAction(new OsluskivacPocni(this));

    }

    public void poruka(String poruka) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Poruka:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(poruka);
        infoAlert.showAndWait();
    }

    public void pocni() {

        System.out.println("Kliknuli ste na dugme da zapocnete igru!");
        // this.fxcon.label.setText("Zapocni igru iz paketa GUIgrica!");

    }

    public List<Kartica> postaviSlikuNaKarticu() {
        kartice = new ArrayList<>();
        int br = 0;

        for (int i = 0; i <= 17; i++) {
            Kartica k1 = new Kartica("/Slike/slika" + String.valueOf(i) + ".png");
            k1.setId(String.valueOf(br));
            System.out.println("Referenca kartice 1: " + k1);
            kartice.add(k1);

            Kartica k2 = new Kartica("/Slike/slika" + String.valueOf(i) + ".png");
            k2.setId(String.valueOf(br));
            System.out.println("Referenca kartice 2: " + k2);
            kartice.add(k2);

            br++;
        }
        Collections.shuffle(kartice);
        return kartice;
    }

    public Kartica[][] vratiTalon() {
        List<Kartica> lista = postaviSlikuNaKarticu();
        Kartica[][] talon = new Kartica[6][6];
        int brojac = 0;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                Kartica k = lista.get(brojac);
                System.out.println("Referenca na karticu: " + k);
                System.out.println("URL kartice iz vrati talon metode je:" + k.getUrl());
                talon[i][j] = k;
                brojac++;
            }
        }
        return talon;
    }

    public void postaviTalonForma() {
        Kartica[][] talon = vratiTalon();

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                Kartica k = talon[i][j];
                //sada na ovu karticu moram da dodam osluskivace
                k.setFitHeight(120);
                k.setFitWidth(140);
                k.setPreserveRatio(true);
                k.setOnMouseExited(new OsluskivacZatvoriKarticu(k, izabranaKartica));
                k.setOnMouseClicked(new OsluskivacOkreniKarticu(k, izabranaKartica, this));
                HBox hbox = new HBox(k);
                hbox.setAlignment(Pos.CENTER);
                this.fxcon.grid.add(hbox, i, j);

            }
        }

    }

    public boolean sveUpareno() {
        for (Kartica k : kartice) {
            if (k.isOkrenuta() == false) {
                return false;
            }
        }
        return true;
    }

    /*
    public List<Kartica> postaviSliku() {
        //ovde cu svakoj kartici dodeliti sliku

        //ovo mora preko matrice!
        //jer u suprotnom cuva iste slike 
        kartice = new ArrayList<>();
        int br = 0;
        for (int i = 0; i <= 7; i++) {
            //postavljam svakoj kartici URL, svaka kartica ce se u listi ponoviti dva puta
            Kartica kartica1 = new Kartica("/Slike/image" + String.valueOf(i) + ".png");
            System.out.println("URL kartice 1 " + kartica1.getUrl());
            // kartica1.setId(String.valueOf(br));
            System.out.println("Referenca kartice 1: " + kartica1);
            
            Kartica kartica2 = new Kartica("/Slike/image" + String.valueOf(i) + ".png");
            System.out.println("URL kartice 2 " + kartica2.getUrl());
            //kartica2.setId(String.valueOf(br++));
            System.out.println("Referenca kartice 2" + kartica2);
            
            kartice.add(kartica1);
            kartice.add(kartica2);

            //sad u listi imam dve kartice sa istim urlom i istim idjem  jer ce mi trebati par da ih okrenem
            //pa cu sve to izmesati u listi i postaviti na talon
            //PRAVITI IH OVDE JEDNA PO JENDU TAKO DA SVAKA IMA SVOJ ID i cuvati ih u matrici
            //ili smisliti kako ces da uporedis da l su jednake, peske pa polako
        }
        Collections.shuffle(kartice);
        return kartice;
        
    }
     */
 /*
    public List<Kartica> postaviSliku2() {
        kartice = new ArrayList<>();
        int br = 0;
        for (int i = 0; i <= 7; i++) {
            Kartica k1 = new Kartica();
            k1.setUrl("/Slike/image" + i + ".png");
            System.out.println("Referenca kartice 1 iz nove metode: " + k1);
            kartice.add(k1);
        }
        //prvi put prolazim i dodajem sve slike jednom

        for (int j = 0; j <= 7; j++) {
            Kartica k2 = new Kartica();
            k2.setUrl("/Slike/image" + j + ".png");
            System.out.println("Referenca kartice 2 iz nove metode: " + k2);
            kartice.add(k2);
        }
        //drugi put prolazim i dodajem sve slike jos jednom

        return kartice;
    }
     */
 /*

    public Kartica[][] vratiTalon() {
        List<Kartica> lista = postaviSliku2();
        Kartica[][] talon = new Kartica[4][4];
        int brojac = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                Kartica k = new Kartica(lista.get(brojac).getUrl());
                System.out.println("Referenca na karticu: " + k);
                System.out.println("URL kartice iz vrati talon metode je:" + k.getUrl());
                talon[i][j] = k;
                brojac++;
            }
        }
        return talon;
    }
     */
 /*
    public void postaviTalonKartica() {

        Kartica[][] talon = vratiTalon();

        Kartica k = new Kartica("/Slika/image0.png");
        Kartica k1 = new Kartica("/Slika/image0.png");
        //HBox hbox = new HBox(k);

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                Kartica kart = talon[i][j];
                HBox hbox = new HBox(kart);
                this.fxcon.grid.add(hbox, i, j);
            }
        }
     */
    //this.fxcon.grid.add(k, 0, 0);
    //this.fxcon.grid.add(k1, 0, 1);
    // this.fxcon.kartica1.getChildren().add(k);
    /*
        this.fxcon.kartica1.getChildren().add(k);
        this.fxcon.kartica2.getChildren().add(k1);
     */
    //znaci mogu dodati u razlicite hbox eve dve iste url kartice
    // int brojac = 0;
    /* Ovo radi, smisliti kako da nemas 16 slika, ili kako preko nekog id ja da proveris da li su iste slike  
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                Kartica k = new Kartica("/Slika/image" + brojac + ".png");
                this.fxcon.grid.add(k, i, j);
                brojac++;
                System.out.println("Brojac :" + brojac);

            }
        }
     */
 /*
        List<Kartica> kartice = postaviSliku();
        int br = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                Kartica k = new Kartica();
                k.setUrl(kartice.get(br).getUrl());
                k.setId(kartice.get(br).getId());
                //na k instancu kartice cu dodati event hendlere
                this.fxcon.grid.add(k, i, j);
                System.out.println("Redni broj dodate kartice: " + br);
                br++;

            }
        }
     */
 /*
        Kartica k = new Kartica("/Slike/image0.png");
        Kartica k1 = new Kartica("/Slike/image1.png");
        Kartica k2 = new Kartica("/Slike/image2.png");
        Kartica k3 = new Kartica("/Slike/image3.png");

        Kartica k4 = new Kartica("/Slike/image4.png");
        Kartica k5 = new Kartica("/Slike/image5.png");

        this.fxcon.grid.add(k, 0, 0);
        this.fxcon.grid.add(k1, 0, 1);
        this.fxcon.grid.add(k2, 0, 2);

        this.fxcon.grid.add(k3, 1, 0);
        this.fxcon.grid.add(k4, 1, 1);
        this.fxcon.grid.add(k5, 1, 2);
     */
 /*
        this.fxcon.kartica1.setSpacing(10);
        this.fxcon.kartica1.getChildren().add(k);
        this.fxcon.kartica2.setSpacing(10);
        this.fxcon.kartica2.getChildren().add(k1);
        this.fxcon.kartica3.setSpacing(10);
        this.fxcon.kartica3.getChildren().add(k2);
        this.fxcon.kartica4.setSpacing(10);
        this.fxcon.kartica4.getChildren().add(k3);

     */
    //this.fxcon.kartica1.getChildren().add(k);
    // this.fxcon.kartica2.getChildren().add(k);
    //this.fxcon.grid.add(k, 1, 0);
    // this.fxcon.grid.add(k, 0, 2);
    // this.fxcon.grid.add(k, 1, 0);
    // this.fxcon.grid.add(k, 1, 2);
//}

    /*
    public void postaviTalon() {

        List<Kartica> kartice = postaviSliku2();

        int br = 0;

        for (int j = 0; j <= 3; j++) {
            HBox hbox = new HBox();
            for (int i = 0; i <= 3; i++) {
                Kartica kartica = kartice.get(br);
                ++br;
                System.out.println("Kartica koja se dodaje je: " + kartica.getId() + "a br za sledecu je:" + br);
                hbox.setPadding(new Insets(10, 10, 1, 40));
                hbox.setSpacing(10);
                hbox.setAlignment(Pos.CENTER);
                try {
                    hbox.getChildren().add(kartica);
                } catch (Exception e) {
                    System.err.println("Greska prilikom dodavanja hbox-a" + e.getCause());
                }
            }
            //vbox.getChildren().add(hbox);
        }
     */
 /*
        vbox.setAlignment(Pos.CENTER);
        rootSceen.add(vbox, 0, 0);
        stage.setTitle("Avengers memory game");
        stage.setWidth(600);
        stage.setHeight(600);
        stage.setScene(new Scene(rootSceen));
        stage.show();
     */
    //return stage;
    // }
}
