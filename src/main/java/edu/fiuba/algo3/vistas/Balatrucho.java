package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Balatrucho extends Application {
    @Override
    public void start(Stage stage) {
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.setView("/fxml/titleScene.fxml"); // Carga la vista inicial
        sceneManager.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
