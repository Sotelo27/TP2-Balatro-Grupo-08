package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.ICarta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;

public class RoundSceneController2 implements Initializable {

    @FXML public TilePane tarotsGuardados;
    @FXML public TilePane cartasEnMano;
    @FXML private AnchorPane roundPane;
    @FXML public Button playHandBtn;
    @FXML public Button doDiscardBtn;

    private BalatroAlgo3 modelo;
    private ObservableList<PaneCarta> selectedCards = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setModelo(BalatroAlgo3 modelo) {
        this.modelo = modelo;

        cartasEnMano.getChildren().forEach(node -> {
            if (node instanceof PaneCarta) {
                CardSelector.hacerImagenSeleccionable((PaneCarta) node);
                node.setOnMouseClicked(event -> CardSelector.handleCardSelection((PaneCarta) node, selectedCards, cartasEnMano));
            }
        });

        ButtonManager.iniciarBotones(playHandBtn, doDiscardBtn, selectedCards);
        iniciarTurno();
    }

    private void iniciarTurno() {
        modelo.iniciarRonda();
        cargarImagenes();
    }

    private void cargarImagenes() {
        CartasManager.cargarCartas(modelo.getCartasEnMano(), cartasEnMano);
        CartasManager.cargarCartas(modelo.getCartasActivables(), tarotsGuardados);
    }
}