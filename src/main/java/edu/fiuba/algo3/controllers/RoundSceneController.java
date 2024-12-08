package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.ICarta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Observer;
import java.util.ResourceBundle;

public class RoundSceneController implements Initializable{
    @FXML public TilePane tarotsGuardados;
    @FXML public Label puntosObjetivo;
    @FXML public Label manos;
    @FXML public Label descartes;
    @FXML public Label numeroRonda;

    @FXML TilePane comodinesActivos;
    @FXML private TilePane cartasEnMano;

    @FXML private AnchorPane roundPane;

    private BalatroAlgo3 modelo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setModelo(BalatroAlgo3 modelo) {
        this.modelo = modelo;
        iniciarTurno();
    }


    private void iniciarTurno() {
        modelo.iniciarRonda();
        cargarImagenes();
        cargarEtiquetas();
    }

    private void cargarEtiquetas() {
        puntosObjetivo.setText(modelo.getPuntajeObjetivo());
        descartes.setText(modelo.getDescartesRestantes());
        manos.setText(modelo.getManosRestantes());
        numeroRonda.setText(modelo.getNumeroRonda());
    }

    private void cargarImagenes() {
        cargarCartasEnMano();
        cargarTarotsGuardados();
        cargarComodinesActivos();
    }

    private void cargarComodinesActivos() {
        List<ICarta> comodines = modelo.getComodinesActivos();
        List<javafx.scene.Node> children = comodinesActivos.getChildren();
        int pos = 0;
        for ( ICarta items : comodines ) {
            ImageView imageView = (ImageView) children.get(pos);
            System.out.println(items.getImagen());
            imageView.setImage(new Image(getResourcePath2(items.getImagen())));
            pos ++;
        }
    }
    private void cargarTarotsGuardados() {
        List<ICarta> especiales = modelo.getCartasActivables();
        Integer pos = 0;
        List<javafx.scene.Node> children = tarotsGuardados.getChildren();
        for ( ICarta items : especiales ) {
            ImageView imageView = (ImageView) children.get(pos);
            System.out.println(items.getImagen());
            imageView.setImage(new Image(getResourcePath2(items.getImagen())));
            pos ++;
        }
    }

    private InputStream getResourcePath2(String path) {
        System.out.println(path);
        InputStream file = getClass().getResourceAsStream(path);
        if (file == null) {
            return getClass().getResourceAsStream("/images/cartas/2 de Corazones.png");
        }
        return file;
    }

    private void cargarCartasSeleccionadas() {

    }

    private void cargarCartasEnMano() {
        List<ICarta> cartas = this.modelo.getCartasEnMano();
        Integer pos = 0;
        List<javafx.scene.Node> children = cartasEnMano.getChildren();
        for ( ICarta item : cartas ) {
            ImageView imageView = (ImageView) children.get(pos);
            imageView.setImage(new Image(getResourcePath2(item.getImagen())));
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
