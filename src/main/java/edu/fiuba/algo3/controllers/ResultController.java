package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ResultController extends GameController{

    @FXML
    public void restartGame(ActionEvent event) {
        // Lógica para reiniciar el juego
        System.out.println("Reiniciando el juego...");
        this.modelo.reiniciar();
    }

    @FXML
    public void backToMainMenu(ActionEvent event){
        // Lógica para volver al menú principal
        System.out.println("Volviendo al menú principal...");
        // Cambiar a la escena del menú principal
        this.modelo.update();
    }

}
