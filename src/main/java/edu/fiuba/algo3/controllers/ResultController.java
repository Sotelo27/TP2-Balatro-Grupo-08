package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import javafx.fxml.FXML;

public class ResultController {
    @FXML
    public void restartGame() {
        // Lógica para reiniciar el juego
        System.out.println("Reiniciando el juego...");
        // Cambiar a la escena del juego
    }

    @FXML
    public void backToMainMenu() {
        // Lógica para volver al menú principal
        System.out.println("Volviendo al menú principal...");
        // Cambiar a la escena del menú principal
    }

    public void setModelo(BalatroAlgo3 modelo) {

    }
}
