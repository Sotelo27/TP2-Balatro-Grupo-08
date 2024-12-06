package edu.fiuba.algo3.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ShopSceneController {

    @FXML
    private ImageView fifthCardOffert;

    @FXML
    private ImageView firstCardOffert;

    @FXML
    private ImageView fourthCardOffert;

    @FXML
    private ImageView scndCardOffert;

    @FXML
    private ImageView thrdCardOffert;

    @FXML
    void selectFirstCard(MouseEvent event) {
        System.out.println("firstCardOffert selected");
    }

    @FXML
    void selectFifthCard(MouseEvent event) {
        System.out.println("fifthCardOffert selected");
    }

    @FXML
    void selectFourthCard(MouseEvent event) {
        System.out.println("fourthCardOffert selected");
    }

    @FXML
    void selectScndCard(MouseEvent event) {
        System.out.println("scndCardOffert selected");
    }

    @FXML
    void selectThirdCard(MouseEvent event) {
        System.out.println("thirdCardOffert selected");
    }
}
