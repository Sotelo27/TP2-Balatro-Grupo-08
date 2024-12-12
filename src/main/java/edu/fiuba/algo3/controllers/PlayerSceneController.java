package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerSceneController extends GameController implements Initializable {

    @FXML
    private Button btnNameSaver;

    @FXML
    private TextField usernameField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



    @FXML
    void saveNameAndStartGame(ActionEvent event) throws IOException {
        this.modelo.setJugador(usernameField.getText());
        this.modelo.update();
    }

    @FXML
    void backToTitle(ActionEvent event) throws IOException {
        this.modelo.reiniciar();
    }

}
