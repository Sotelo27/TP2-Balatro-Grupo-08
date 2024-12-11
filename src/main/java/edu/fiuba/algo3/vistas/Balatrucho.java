package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controllers.SceneController;
import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.Estados.EstadoInicio;
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

        SceneController switcher = new SceneController();
        switcher.setStage(stage);

        EstadoInicio estado = new EstadoInicio();

        BalatroAlgo3 modelo = new BalatroAlgo3(new LectorDeJSON());

        estado.setModel(modelo);
        estado.setSwitcher(switcher);

        switcher.setGameState(modelo);

        stage.show();
        modelo.setEstado(estado);
    }

    public static void main(String[] args) {
        launch(args);
    }

}