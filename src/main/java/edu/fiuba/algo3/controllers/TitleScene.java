package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleScene {
    @FXML
    private Button playBtn;
    @FXML
    private Button exitBtn;
    Stage stage;
    @FXML
    private AnchorPane mainPane;

    private SceneController switcher;

    public TitleScene() {
        this.switcher = new SceneController();
    }

    @FXML
    void click(ActionEvent event) throws IOException {
        System.out.println("Iniciar Juego");
        switcher.switchToPlayerScene(event);
    }

    @FXML
    void exitClicked(ActionEvent event) {
        stage = (Stage) mainPane.getScene().getWindow();
        System.out.println("Saliending");
        stage.close();
    }
}
