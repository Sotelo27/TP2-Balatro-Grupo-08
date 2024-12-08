package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Balatrucho extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        // Load FXML and set controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/titleScene.fxml"));
        Parent root = loader.load();

        // Set the scene
        Image icon = new Image(getClass().getResourceAsStream("/images/mainIcon.png"));
        Scene scene = new Scene(root);
        stage.setTitle("Balatrucho-Fiuba");
        stage.setScene(scene);

        stage.sizeToScene(); // Ajusta el tamaño de la ventana al tamaño de la escena
        stage.getIcons().add(icon);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}