package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ResultController extends GameController{

    @FXML
    public void restartGame(ActionEvent event) {
        // Lógica para reiniciar el juego
        this.modelo.reiniciar();
    }

    @FXML
    public void backToMainMenu(ActionEvent event){
        // Cambiar a la escena del menú principal
        this.modelo.update();
    }

}
