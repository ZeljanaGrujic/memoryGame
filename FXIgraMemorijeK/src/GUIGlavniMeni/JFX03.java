package GUIGlavniMeni;

import Server_client.Korisnik;
import java.net.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author user
 */
public class JFX03 extends Application {

    FXMLDocumentController con;
    // Long idKorisnika;

    @Override
    public void start(Stage stage) throws Exception {

        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLDocumentController) fxmlLoader.getController();

        con.postaviStage(stage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Glavni meni");
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public GUIGlavniMeni.FXMLDocumentController getController() {
        return con;
    }

    public void zatvoriFormu() {

        con.stage.close();
    }

    public void postaviUlogovanogKorisnika(Long id) {
        con.idKorisnika = id;
        System.out.println("GUIGlavniMeni.JFX03.postaviUlogovanogKorisnika() njegov ID je: " + con.idKorisnika);
    }

    public Long vratiUlogovanogKorisnika() {
        return con.idKorisnika;
    }

    public void postaviKorisnika(Korisnik kor) {
        con.ulogovaniKor = kor;
        System.out.println("GUIGlavniMeni.JFX03.postaviUlogovanogKorisnika() njegov ID je izvucen iz celog objekta: " + con.ulogovaniKor.getIdKorisnik());
    }

    public Korisnik vratiKorisnika() {
        return con.ulogovaniKor;
    }

}
