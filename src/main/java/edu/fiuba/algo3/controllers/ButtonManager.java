package edu.fiuba.algo3.controllers;

import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;

public class ButtonManager {
    public static void iniciarBotones(Button playHandBtn, Button doDiscardBtn, ObservableList<PaneCarta> selectedCards) {
        playHandBtn.setDisable(selectedCards.isEmpty());
        doDiscardBtn.setDisable(selectedCards.isEmpty());

        playHandBtn.setOnAction(e -> {
            if (selectedCards.isEmpty()) {
                System.out.println("No hay cartas seleccionadas para jugar.");
            } else {
                // Lógica para realizar jugada
            }
        });

        doDiscardBtn.setOnAction(e -> {
            if (selectedCards.isEmpty()) {
                System.out.println("No hay cartas seleccionadas para descartar.");
            } else {
                // Lógica para realizar descarte
            }
        });

        // Listener para detectar cambios en la lista de cartas seleccionadas
        selectedCards.addListener((ListChangeListener.Change<? extends PaneCarta> change) -> {
            playHandBtn.setDisable(selectedCards.isEmpty());
            doDiscardBtn.setDisable(selectedCards.isEmpty());
        });
    }
}
