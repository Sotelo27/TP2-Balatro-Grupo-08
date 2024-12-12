package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleSceneController extends GameController{
    @FXML
    private Button playBtn;
    @FXML
    private Button exitBtn;
    private Stage stage;
    @FXML
    private AnchorPane mainPane;


    public TitleSceneController() {
    }

    @FXML
    void click(ActionEvent event) throws IOException {
        System.out.println("Iniciar Juego");

        this.modelo.update();
    }

    @FXML
    void exitClicked(ActionEvent event) {
        this.modelo.terminar();
        System.out.println("Saliending");
        stage.close();
    }
}
