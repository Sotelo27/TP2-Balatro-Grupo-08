package edu.fiuba.algo3.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TransitionController extends GameController {
    @FXML
    public Button continueBtn, btnMainMenu;


    public void continueBtnAction() {
        modelo.update();
    }
}
