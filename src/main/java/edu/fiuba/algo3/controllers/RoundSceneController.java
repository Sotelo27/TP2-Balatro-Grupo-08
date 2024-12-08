package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.ICarta;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
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
    @FXML private ImageView card1;
    @FXML private ImageView card2;
    @FXML private ImageView card3;
    @FXML private ImageView card4;
    @FXML private ImageView card5;
    @FXML private ImageView card6;
    @FXML private ImageView card7;
    @FXML private ImageView card8;

    private BalatroAlgo3 modelo;
    private List<ImageView> selectedCards = new ArrayList<>();
    private final DropShadow hoverEffect = new DropShadow(10, Color.BLUE);
    private final DropShadow selectedEffect = new DropShadow(15, Color.rgb(255, 0, 0, 0.5)); // Rojo claro semi-transparente
    private static final double SCALE_FACTOR = 1.1; // 10% más grande



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setModelo(BalatroAlgo3 modelo) {
        this.modelo = modelo;
        cartasEnMano.getChildren().forEach(node -> {
            if (node instanceof ImageView) {
                hacerSeleccionable((ImageView) node);
            }

        });
        iniciarTurno();
    }

    private void hacerSeleccionable(ImageView card) {
        card.setPickOnBounds(true);

        // Configurar la transición de escalado
        ScaleTransition growTransition = new ScaleTransition(Duration.millis(100), card);
        growTransition.setToX(SCALE_FACTOR);
        growTransition.setToY(SCALE_FACTOR);

        ScaleTransition shrinkTransition = new ScaleTransition(Duration.millis(100), card);
        shrinkTransition.setToX(1.0);
        shrinkTransition.setToY(1.0);


        card.setOnMouseEntered(e -> {
            if (!selectedCards.contains(card)) {
                growTransition.play();
            }
        });

        card.setOnMouseExited(e -> {
            if (!selectedCards.contains(card)) {
                shrinkTransition.play();
                card.setEffect(null);
            }
        });
        card.setOnMouseClicked(event -> handleCardSelection(card));
    }

    private void handleCardSelection(ImageView card) {
        if (selectedCards.contains(card)) {
            deselectCard(card);
        } else if (selectedCards.size() >= 5) {
            deselectCard(selectedCards.get(0));
            selectCard(card);
        } else {
            selectCard(card);
        }}

    private void selectCard(ImageView card) {
        selectedCards.add(card);
        card.setScaleX(SCALE_FACTOR);
        card.setScaleY(SCALE_FACTOR);
        card.getStyleClass().add("selected-card");
    }

    private void deselectCard(ImageView card) {
        selectedCards.remove(card);
        card.setScaleX(1.0);
        card.setScaleY(1.0);
        card.getStyleClass().remove("selected-card");
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

    private InputStream getResourcePath2(String path) {
        System.out.println(path);
        InputStream file = getClass().getResourceAsStream(path);
        if (file == null) {
            return getClass().getResourceAsStream("/images/cartas/2 de Corazones.png");
        }
        return file;
    }

}
