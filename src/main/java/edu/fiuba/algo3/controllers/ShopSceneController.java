package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShopSceneController implements Initializable {

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
    private TilePane cardOffersPane;

    private BalatroAlgo3 modelo;

    @FXML
    void selectFirstCard(MouseEvent event) {
        comparCarta(1);
        System.out.println("firstCardOffert selected");
    }


    @FXML
    void selectScndCard(MouseEvent event) {
        comparCarta(2);
        System.out.println("scndCardOffert selected");
    }

    @FXML
    void selectThirdCard(MouseEvent event) {
        comparCarta(3);
        System.out.println("thirdCardOffert selected");
    }

    @FXML
    void selectFourthCard(MouseEvent event) {
        comparCarta(4);
        System.out.println("fourthCardOffert selected");
    }

    @FXML
    void selectFifthCard(MouseEvent event) {
        comparCarta(5);
        System.out.println("fifthCardOffert selected");
    }

    public void setModelo(BalatroAlgo3 modelo) {
        this.modelo = modelo;
        cargarItemsDeTienda();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void cargarItemsDeTienda() {
        List<String > items = modelo.getCartasDeTienda();
        Integer pos = 0;
        List<javafx.scene.Node> children = cardOffersPane.getChildren();
        for ( String item : items ) {
            ImageView imageView = (ImageView) children.get(pos);
            imageView.setImage(new Image(getResourcePath(item)));
            pos ++;
        }
    }

    private InputStream getResourcePath(String item) {
        String path = "/images/cartas/" + item + ".png";
        System.out.println(path);
        InputStream file = getClass().getResourceAsStream(path);
        if (file == null) {
            return getClass().getResourceAsStream("/images/cartas/2 de Corazones.png");
        }
        return file ;
    }

    private void comparCarta(int posicion) {
        String carta = modelo.getCartasDeTienda().get(posicion-1);
        modelo.seleccionarCartaDePoker(carta);
        goNextStage();
    }

    private void goNextStage() {

    }
}
