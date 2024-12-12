package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controllers.SceneController;
import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.Estados.EstadoInicio;
import edu.fiuba.algo3.modelo.Estados.EstadoJuego;
import edu.fiuba.algo3.repositorios.LectorDeJSON;
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

        BalatroAlgo3 modelo = new BalatroAlgo3(new LectorDeJSON());

        SceneController switcher = new SceneController();
        switcher.setStage(stage);
        switcher.setGameState(modelo);

        EstadoInicio estadoInicial = new EstadoInicio();
        EstadoJuego estadoJuego = new EstadoJuego(switcher, estadoInicial);
        modelo.setEstado(estadoJuego);
        estadoJuego.render();


    }

    public static void main(String[] args) {
        launch(args);
    }

}