package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Observer;
import java.util.ResourceBundle;

public class RoundSceneController implements Initializable{
    @FXML private TilePane cartasEnMano;

    @FXML private AnchorPane roundPane;

    private BalatroAlgo3 modelo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setModelo(BalatroAlgo3 modelo){
        this.modelo = modelo;
        cargarCartasEnMano();
    }

    private void cargarCartasEnMano() {
        List<String> cartas = this.modelo.getCartasEnMano();
        Integer pos = 0;
        List<javafx.scene.Node> children = cartasEnMano.getChildren();
        for ( String item : cartas ) {
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
            return getClass().getResourceAsStream("/images/cartas/joker.png");
        }
        return file ;
    }
}
