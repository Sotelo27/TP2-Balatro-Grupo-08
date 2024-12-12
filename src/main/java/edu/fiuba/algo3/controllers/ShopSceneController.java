package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.ICarta;
import edu.fiuba.algo3.modelo.IModelo;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShopSceneController extends GameController implements Initializable {

    @FXML Text nombreObjeto, descripcionObjeto;

    @FXML PaneCarta choosedCard;

    @FXML private TilePane cardOffersPane, tarotsGuardados;

    private IModelo modelo;

    private ICarta selectedCard;

    void setBehaviour(PaneCarta card){
        card.setOnMouseEntered(e -> {
            card.agrandar(1.1);
        });
        card.setOnMouseExited(e -> {
            card.agrandar(1.0);
        });
        card.setOnMouseClicked(e -> {
            preSeleccionar(card);
            card.playClick();
        });
    }

    @Override
    public void setModelo(IModelo modelo) {
        this.modelo = modelo;
        cargarItems();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private void cargarItems() {
        List<ICarta> comprables = modelo.getCartasDeTienda();
        cargarCartas(comprables, cardOffersPane);
        List<ICarta> tarots = modelo.getCartasActivables();
        cargarCartas(tarots,tarotsGuardados );

        cardOffersPane.getChildren().forEach(cardPane -> {
            if (cardPane instanceof PaneCarta) {
                PaneCarta card = (PaneCarta) cardPane;
                setBehaviour(card);
            }
        });
    }

    private void preSeleccionar(PaneCarta carta) {

        selectedCard = carta.getCarta();
        this.choosedCard.setImage(carta.getImage());
        this.nombreObjeto.setText(selectedCard.getNombre());
        this.descripcionObjeto.setText(selectedCard.getDescripcion());
    }

    public void comprarCarta(MouseEvent mouseEvent){
        choosedCard.playClick();
        modelo.seleccionarCartaDeTienda(selectedCard);
        modelo.update();
    }
    private void cargarCartas(List<ICarta> cartas, TilePane contenedor) {
        List<javafx.scene.Node> children = contenedor.getChildren();
        for (int i = 0; i < cartas.size(); i++) {
            ICarta carta = cartas.get(i);
            PaneCarta imageView = (PaneCarta) children.get(i);
            imageView.setCarta(carta);
        }
    }
}
