package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.ICarta;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

import javafx.util.Duration;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RoundSceneController implements Initializable{
    @FXML public TilePane tarotsGuardados;
    @FXML public Label puntosObjetivo;
    @FXML public Label manos;
    @FXML public Label descartes;
    @FXML public Label numeroRonda;
    public Button playHandBtn;
    public Button doDiscardBtn;

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
    private ObservableList<ImageView> selectedCards = FXCollections.observableArrayList();

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
        iniciarBotones();
    }

    private void iniciarBotones() {
        // Inicialmente deshabilitar el botón si la lista está vacía
        playHandBtn.setDisable(selectedCards.isEmpty());
        doDiscardBtn.setDisable(selectedCards.isEmpty());
        playHandBtn.setOnAction(e -> {
            if (manos.getText().equals("0")) {
                System.out.println("End game");
            } else {
                realizarJugada();
            }
        });
        doDiscardBtn.setOnAction(e -> {
            if (descartes.getText().equals("0")) {
                System.out.println("No quedan mas descartes");
            } else {
                realizarDescarte();
            }
        });

        // Listener para detectar cambios en la lista de cartas seleccionadas
        selectedCards.addListener((ListChangeListener.Change<? extends ImageView> change) -> {
            playHandBtn.setDisable(selectedCards.isEmpty());
            doDiscardBtn.setDisable(selectedCards.isEmpty());
        });
    }

    private void realizarDescarte() {
        if (selectedCards.isEmpty()) {
            doDiscardBtn.setDisable(true);
        } else {
            System.out.println("Descarte:");
            seleccionarCartasEnModelo();
            modelo.realizarDescarte();

            selectedCards.clear();
        }
        iniciarTurno();
    }
    private void realizarJugada() {
        if (selectedCards.isEmpty()) {
            playHandBtn.setDisable(true);
        } else {
            // Aquí va la lógica de realizar la jugada
            System.out.println("Jugada:");
            seleccionarCartasEnModelo();
            modelo.realizarJugada();
            selectedCards.clear();
        }
        iniciarTurno();
    }
    private void seleccionarCartasEnModelo() {
        for (ImageView selectedCard : selectedCards) {
            ICarta carta = (ICarta) selectedCard.getUserData();
            System.out.println(carta.getNombre());
            modelo.seleccionarCartaDePoker(carta.getNombre());
        }
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
            imageView.setImage(new Image(getResourcePath(items.getImagen())));
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
            imageView.setImage(new Image(getResourcePath(items.getImagen())));
            pos ++;
        }
    }

    private void cargarCartasEnMano() {
        List<ICarta> cartas = this.modelo.getCartasEnMano();
        Integer pos = 0;
        List<javafx.scene.Node> children = cartasEnMano.getChildren();
        for ( ICarta item : cartas ) {
            ImageView imageView = (ImageView) children.get(pos);
            imageView.setImage(new Image(getResourcePath(item.getImagen())));
            imageView.setUserData(item);
            pos ++;
        }
    }

    private InputStream getResourcePath(String path) {
        System.out.println(path);
        InputStream file = getClass().getResourceAsStream(path);
        if (file == null) {
            return getClass().getResourceAsStream("/images/cartas/2 de Corazones.png");
        }
        return file;
    }

}
