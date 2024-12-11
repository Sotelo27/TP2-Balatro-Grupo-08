package edu.fiuba.algo3.controllers;

import javafx.scene.layout.TilePane;

public class TarotManager {

    public static void makeTarotClickable(boolean value, TilePane tarotsGuardados) {
        tarotsGuardados.getChildren().forEach(tarot -> {
            if (tarot instanceof PaneCarta) {
                PaneCarta tarotImageView = (PaneCarta) tarot;
                tarotImageView.agrandar(value ? 1.1 : 1.0);
                tarotImageView.setActive(value);
                tarotImageView.setOnMouseClicked(event -> {
                    if (value) {
                        handleTarotActivation(tarotImageView);
                    }
                });
            }
        });
    }

    private static void handleTarotActivation(PaneCarta tarot) {
        // Se activa el tarot
        System.out.println("Activar Tarot");
        System.out.println(tarot.getCarta().getNombre());
    }
}
