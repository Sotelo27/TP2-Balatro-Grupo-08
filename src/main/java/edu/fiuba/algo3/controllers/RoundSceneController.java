package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.Services.ImageLoader;
import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.ICarta;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
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
    @FXML Label puntajeRonda;

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
    private ICarta tarotSeleccionado;

    private static final double SCALE_FACTOR = 1.1; // 10% más grande



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setModelo(BalatroAlgo3 modelo) {
        this.modelo = modelo;
        cartasEnMano.getChildren().forEach(node -> {
            if (node instanceof ImageView) {
                hacerImagenSeleccionable((ImageView) node);
                node.setOnMouseClicked(event -> handleCardSelection((ImageView) node));
            }

        tarotsGuardados.getChildren().forEach(tarot ->{
            if (tarot instanceof ImageView) {
                hacerImagenSeleccionable((ImageView) tarot);
                tarot.setOnMouseClicked(event -> handleTarotActivation((ImageView) tarot));
            }
        });
        });
        //puntajeRonda.textProperty().bind(modelo.puntajeObjetivoProperty());
        iniciarTurno();
    }

    private void handleTarotActivation(ImageView tarot) {
        if (tarotSeleccionado == null) {
            selectedCards.clear();
            selectCard(tarot);
            tarotSeleccionado = (ICarta) tarot.getUserData();
            cartasEnMano.getStyleClass().add("prepare-for-tarot");
            tarotsGuardados.getStyleClass().add("prepare-for-tarot");
        } else {
            deselectCard(tarot);
            cartasEnMano.getStyleClass().remove("prepare-for-tarot");
            tarotSeleccionado = null;
        }

    }


    private void hacerImagenSeleccionable(ImageView card) {
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
    }

    private void handleCardSelection(ImageView card) {
        if (selectedCards.contains(card)) {
            deselectCard(card);
        } else if (selectedCards.size() >= 5) {
            deselectCard(selectedCards.get(0));
            selectCard(card);
        } else {
            selectCard(card);
        }
    }
            if (tarotSeleccionado != null) {
                ICarta cartaAMejorar = (ICarta) card.getUserData();
                activarTarot(cartaAMejorar);
                handleTarotActivation(card);
                iniciarTurno();
            }else {

                selectCard(card);
            }
        }
    }

    private void deselectCards(TilePane tarotSeleccionado) {
        for (Node node : new ArrayList<>(tarotSeleccionado.getChildren())) { // Usar una copia de la lista
            if (node instanceof ImageView) {
                deselectCard((ImageView) node);

            }
        }
    }


    private void selectCard(ImageView card) {
        if (!selectedCards.contains(card)) {
            selectedCards.add(card);
            card.setScaleX(SCALE_FACTOR);
            card.setScaleY(SCALE_FACTOR);
            card.getStyleClass().add("selected-card");
        }
    }

    private void deselectCard(ImageView card) {
        if (selectedCards.contains(card)) {
            selectedCards.remove(card);
            card.setScaleX(1.0);
            card.setScaleY(1.0);
            card.getStyleClass().remove("selected-card");
        }
    }

    private void activarTarot(ICarta elemento){
        System.out.println("Activar Tarot");
        System.out.println(tarotSeleccionado.getNombre());
        System.out.println(elemento.getNombre());
        modelo.activarTarot(tarotSeleccionado, elemento);
    }

    private void realizarDescarte() {
        System.out.println("Descarte:");
        for (ImageView card : new ArrayList<>(selectedCards)) { // Usar una copia de la lista
            // Realiza operaciones con 'card'
            deselectCard(card);
            ICarta cartaAMejorar = (ICarta) card.getUserData();
            System.out.println(cartaAMejorar.getNombre());
            modelo.seleccionarCartaDePoker(cartaAMejorar.getNombre());
        }
        selectedCards.clear();
        modelo.realizarDescarte();
        iniciarTurno();
    }
    private void realizarJugada() {
        if (selectedCards.isEmpty()) {
            playHandBtn.setDisable(true);
        } else if (selectedCards.contains(tarotsGuardados)){
            // Aquí va la lógica de realizar la jugada

        }else {
            System.out.println("Jugada:");
            for (ImageView card : new ArrayList<>(selectedCards)) {
                ICarta carta = (ICarta) card.getUserData();
                System.out.println(carta.getNombre());
                modelo.seleccionarCartaDePoker(carta.getNombre());
                deselectCard(card);
            }
            selectedCards.clear();
            modelo.realizarJugada();


        }
        iniciarTurno();
    }

    private void iniciarTurno() {
        modelo.iniciarRonda();
        iniciarBotones();
        cargarImagenes();
        cargarEtiquetas();
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

    private void cargarEtiquetas() {

        puntosObjetivo.setText(modelo.getPuntajeObjetivo());
        descartes.setText(modelo.getDescartesRestantes());
        manos.setText(modelo.getManosRestantes());
        numeroRonda.setText(modelo.getNumeroRonda());
        puntajeRonda.setText(String.valueOf(modelo.obtenerPuntajeRonda()));
    }

    private void cargarImagenes() {
        cargarCartas(modelo.getCartasEnMano(), cartasEnMano);
        cargarCartas(modelo.getCartasActivables(), tarotsGuardados);
        cargarCartas(modelo.getComodinesActivos(), comodinesActivos);
    }

    private void cargarCartas(List<ICarta> cartas, TilePane contenedor) {
        List<javafx.scene.Node> children = contenedor.getChildren();
        ImageLoader imageLoader = new ImageLoader();
        for (int i = 0; i < cartas.size(); i++) {
            ICarta carta = cartas.get(i);
            ImageView imageView = (ImageView) children.get(i);
            imageView.setImage(imageLoader.cargarImagen(carta.getImagen()));
            imageView.setUserData(carta);
        }
    }
}
