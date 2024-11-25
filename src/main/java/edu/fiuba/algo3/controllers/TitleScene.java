package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TitleScene {
    @FXML
    private Button btnJugar;

    @FXML
    void click(ActionEvent event) {
        System.out.println("Iniciar Juego");
    }
}
