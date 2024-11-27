package edu.fiuba.algo3.vistas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class VistaTitle extends Application implements Observer {

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image(getClass().getResourceAsStream("/images/mainIcon.png"));
        AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/titleScene.fxml"));
        Scene title = new Scene(root);
        stage.getIcons().add(icon);
        stage.setScene(title);
        stage.setTitle("Balatrucho-Fiuba");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
