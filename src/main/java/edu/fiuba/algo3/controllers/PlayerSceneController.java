package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.repositorios.LectorDeJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerSceneController extends GameController implements Initializable {

    @FXML
    private Button btnNameSaver;

    private SceneController switcher;


    @FXML
    private TextField usernameField;
    private String userName;

    public PlayerSceneController(){
        switcher = new SceneController();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



    @FXML
    void saveNameAndStartGame(ActionEvent event) throws IOException {
        this.userName = usernameField.getText();
        this.modelo.setJugador(userName);
        this.modelo.update();
    }

    @FXML
    void backToTitle(ActionEvent event) throws IOException {
        switcher.switchToMainScene(event);
    }

}
