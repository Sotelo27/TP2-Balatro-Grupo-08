package edu.fiuba.algo3.controllers;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

import javafx.scene.layout.TilePane;



public class CardSelector {
    private static final double SCALE_FACTOR = 1.1;

    public static void hacerImagenSeleccionable(ImageView card) {
        card.setPickOnBounds(true);

        ScaleTransition growTransition = new ScaleTransition(Duration.millis(100), card);
        growTransition.setToX(SCALE_FACTOR);
        growTransition.setToY(SCALE_FACTOR);

        ScaleTransition shrinkTransition = new ScaleTransition(Duration.millis(100), card);
        shrinkTransition.setToX(1.0);
        shrinkTransition.setToY(1.0);

        card.setOnMouseEntered(e -> growTransition.play());
        card.setOnMouseExited(e -> shrinkTransition.play());
    }

    public static void handleCardSelection(PaneCarta card, ObservableList<PaneCarta> selectedCards, TilePane cartasEnMano) {
        if (selectedCards.contains(card)) {
            deselectCard(card, selectedCards);
        } else if (selectedCards.size() >= 5) {
            deselectCard(selectedCards.get(0), selectedCards);
            selectCard(card, selectedCards);
        } else {
            cartasEnMano.getStyleClass().add("prepare-for-tarot");
            selectCard(card, selectedCards);
        }
    }

    private static void selectCard(PaneCarta card, ObservableList<PaneCarta> selectedCards) {
        if (!selectedCards.contains(card)) {
            selectedCards.add(card);
            card.setScaleX(SCALE_FACTOR);
            card.setScaleY(SCALE_FACTOR);
            card.getStyleClass().add("selected-card");
        }
    }

    private static void deselectCard(PaneCarta card, ObservableList<PaneCarta> selectedCards) {
        if (selectedCards.contains(card)) {
            selectedCards.remove(card);
            card.setScaleX(1.0);
            card.setScaleY(1.0);
            card.getStyleClass().remove("selected-card");
        }
    }
}
