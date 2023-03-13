package GUIKorisnikPrijavljivanje;

import java.net.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import GUIKorisnikPrijavljivanje.GUIKontrolerPrijavljivanje.*;
import GUIKorisnikPrijavljivanje.FXMLDocumentController;

/**
 *
 * @author user
 */
public class JFX02 extends Application {

    GUIKorisnikPrijavljivanje.FXMLDocumentController con;

    @Override
    public void start(Stage stage) throws Exception {

        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLDocumentController) fxmlLoader.getController();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Prijavi se");
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public FXMLDocumentController getController() {
        return con;
    }

}
