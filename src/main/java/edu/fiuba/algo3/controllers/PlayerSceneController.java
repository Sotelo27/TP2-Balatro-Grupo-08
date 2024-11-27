package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class PlayerSceneController {

    @FXML
    private Button btnNameSaver;
    private SceneController switcher;

    public PlayerSceneController(){
        switcher = new SceneController();
    }

    @FXML
    void click(ActionEvent event) {

    }

    @FXML
    void backToTitle(ActionEvent event) throws IOException {
        switcher.switchToMainScene(event);
    }
}
