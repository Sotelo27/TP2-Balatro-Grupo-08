package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ResultController extends GameController{

    @FXML
    public void restartGame(ActionEvent event) throws IOException {
        // Lógica para reiniciar el juego
        System.out.println("Reiniciando el juego...");
        //this.modelo.reiniciar();
    }

    @FXML
    public void backToMainMenu(ActionEvent event) throws IOException {
        // Lógica para volver al menú principal
        System.out.println("Volviendo al menú principal...");
        // Cambiar a la escena del menú principal
        this.modelo.update();
    }

}
