package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class PlayerSceneController {

    @FXML
    private Button btnNameSaver;

    private SceneController switcher;

    @FXML
    private TextField usernameField;
    private String userName;

    public PlayerSceneController(){
        switcher = new SceneController();
    }

    @FXML
    void saveName(ActionEvent event) {
        this.userName = usernameField.getText();
        System.out.println(this.userName);
    }

    @FXML
    void backToTitle(ActionEvent event) throws IOException {
        switcher.switchToMainScene(event);
    }
}
