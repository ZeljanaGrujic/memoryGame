/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author user
 */
public class Kartica extends ImageView {

    private static final String unknown = "/Slike/bgImage.jpg";
    private String url;
    private boolean okrenuta;

    public Kartica() {
        this.setFitWidth(180);
        this.setFitHeight(170);
        this.setPreserveRatio(true);
    }

    public Kartica(String url) {
        super(unknown);
        this.url = url;
        this.setFitWidth(180);
        this.setFitHeight(170);
        this.setPreserveRatio(true);
    }

    public static String getUnknown() {
        return unknown;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isOkrenuta() {
        return okrenuta;
    }

    public void setOkrenuta(boolean okrenuta) {
        this.okrenuta = okrenuta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Kartica kartica = (Kartica) obj;
        if (!((Kartica) obj).getId().equals(this.getId())) {
            return false;
        }
        return Objects.equals(this.url, kartica.url);
    }

    public void zatvori() {
        this.setImage(new Image(unknown));
    }

    public void prikaziKarticu() {
        this.setImage(new Image(url));
    }

    public void otvori() {
        this.setImage(new Image(url));
        this.okrenuta = true;
        this.setFitWidth(180);
        this.setFitHeight(170.0);

        this.setPreserveRatio(true);
    }

    public boolean equalsUrl(Object obj) {
        return obj instanceof Kartica
                && ((Kartica) obj).url.equals(url);
    }

}
