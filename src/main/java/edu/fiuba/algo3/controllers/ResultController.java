package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ResultController {
    private SceneController switcher;
    public ResultController(){
        this.switcher = new SceneController();
    }

    @FXML
    public void restartGame(ActionEvent event) throws IOException {
        // Lógica para reiniciar el juego
        System.out.println("Reiniciando el juego...");
        // Cambiar a la escena del juego

        switcher.switchToPlayerScene(event);
    }

    @FXML
    public void backToMainMenu(ActionEvent event) throws IOException {
        // Lógica para volver al menú principal
        System.out.println("Volviendo al menú principal...");
        // Cambiar a la escena del menú principal
        switcher.switchToMainScene(event);
    }

    public void setModelo(BalatroAlgo3 modelo) {

    }
}
