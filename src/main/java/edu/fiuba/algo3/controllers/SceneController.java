package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToMainScene(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.setView("/fxml/titleScene.fxml"); // Carga la vista inicial
        sceneManager.show();
    }

    public void switchToPlayerScene(ActionEvent event) throws IOException {;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.setView("/fxml/playerScene.fxml"); // Carga la vista inicial
        sceneManager.show();
    }

    public void switchToShopScene(ActionEvent event, BalatroAlgo3 modelo) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.setViewModel("/fxml/shopScene.fxml", modelo); // Pasa el modelo a la vista
        sceneManager.show();
    }
    public void switchToRoundScene(MouseEvent event,BalatroAlgo3 modelo) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.setViewModel("/fxml/RoundScene.fxml",modelo); // Carga la vista inicial
        sceneManager.show();
    }
}
