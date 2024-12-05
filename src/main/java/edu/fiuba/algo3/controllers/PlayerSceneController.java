package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.repositorios.LectorDeJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PlayerSceneController {
    private BalatroAlgo3 modelo;

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
    void saveName(ActionEvent event) throws IOException {
        this.userName = usernameField.getText();
        System.out.println(this.userName);
        this.modelo = new BalatroAlgo3(this.userName, new LectorDeJSON());
        switcher.switchToShopScene(event,this.modelo);
    }

    @FXML
    void backToTitle(ActionEvent event) throws IOException {
        switcher.switchToMainScene(event);
    }
}
