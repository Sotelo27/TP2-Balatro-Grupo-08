package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.Services.ImageLoader;
import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.Estados.EstadoRonda;
import edu.fiuba.algo3.modelo.ICarta;
import edu.fiuba.algo3.modelo.IModelo;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RoundSceneController extends GameController implements Initializable{
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

    private ObservableList<PaneCarta> selectedCards = FXCollections.observableArrayList();
    private ObservableList<PaneCarta> cartasActivables = FXCollections.observableArrayList();

    private static final double SCALE_FACTOR = 1.1; // 10% más grande



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setModelo(IModelo modelo) {
        this.modelo = modelo;
        // hacer las cartas de la mano seleccionables
        cartasEnMano.getChildren().forEach(node -> {
            if (node instanceof ImageView) {
                hacerImagenSeleccionable((PaneCarta) node);
                node.setOnMouseClicked(e -> handleCardSelection((PaneCarta) node));
            }
        });
        //puntajeRonda.textProperty().bind(modelo.puntajeObjetivoProperty());
        iniciarTurno();
    }

    private void handleTarotActivation(PaneCarta tarot) {
        activarTarot( tarot.getCarta());
        tarotsGuardados.getChildren().remove(tarot);
        makeTarotClickable(false);
        tarot.playClick();
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

    private void handleCardSelection(PaneCarta card) {

        if (selectedCards.contains(card)) {
            deselectCard(card);
        } else if (selectedCards.size() >= 5) {
            deselectCard(selectedCards.get(0));
            selectCard(card);
        } else {
            cartasEnMano.getStyleClass().add("prepare-for-tarot");
            makeTarotClickable(true);
            selectCard(card);
        }
        card.playClick();
    }

    private void makeTarotClickable(boolean value) {
        if (value) {
            // Agregar clase para estilo habilitado

            // Hacer las cartas de tarot seleccionables
            tarotsGuardados.getChildren().forEach(tarot -> {
                if (tarot instanceof PaneCarta) {
                    PaneCarta tarotImageView = (PaneCarta) tarot;
                    tarotImageView.agrandar(SCALE_FACTOR);
                    tarotImageView.setActive(true);
                    tarotImageView.setOnMouseClicked(event -> handleTarotActivation(tarotImageView));
                }
            });
        } else {

            // Deshabilitar las cartas de tarot
            tarotsGuardados.getChildren().forEach(tarot -> {
                if (tarot instanceof PaneCarta) {
                    PaneCarta tarotImageView = (PaneCarta) tarot;
                    // Remover la capacidad de ser seleccionadas
                    tarotImageView.agrandar(1.0);
                    tarotImageView.setActive(false);
                    tarotImageView.setOnMouseClicked(null);
                }
            });
        }
    }


    private void selectCard(PaneCarta card) {
        if (!selectedCards.contains(card)) {
            selectedCards.add(card);
            card.setScaleX(SCALE_FACTOR);
            card.setScaleY(SCALE_FACTOR);
            card.getStyleClass().add("selected-card");
        }
    }

    private void deselectCard(PaneCarta card) {
        if (selectedCards.contains(card)) {
            selectedCards.remove(card);
            card.setScaleX(1.0);
            card.setScaleY(1.0);
            card.getStyleClass().remove("selected-card");
        }
    }

    private void activarTarot(ICarta tarot){
        System.out.println("Activar Tarot");
        System.out.println(tarot.getNombre());
        ICarta carta = selectedCards.get(0).getCarta();
        modelo.seleccionarCartaDePoker(carta.getNombre());
        modelo.activarTarot(tarot);
    }

    private void realizarDescarte() {
        System.out.println("Descarte:");
        for (PaneCarta card : new ArrayList<>(selectedCards)) { // Usar una copia de la lista
            // Realiza operaciones con 'card'
            deselectCard(card);
            ICarta cartaAMejorar = card.getCarta();
            System.out.println(cartaAMejorar.getNombre());
            modelo.seleccionarCartaDePoker(cartaAMejorar.getNombre());
        }
        selectedCards.clear();
        modelo.realizarDescarte();
        iniciarTurno();
    }
    private void realizarJugada() {
        if (selectedCards.isEmpty() || modelo.getManosRestantes().equals("0")) {
            playHandBtn.setDisable(true);
        } else {
            System.out.println("Jugada:");
            for (PaneCarta card : new ArrayList<>(selectedCards)) {
                ICarta carta = card.getCarta();
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
/*        if (modelo.rondaSuperada()){
            pasarATienda();
            return;
        } else if (modelo.perdioRonda()) {
            pasarADerrota();
            return;
        }*/
        modelo.iniciarRonda();
        iniciarBotones();
        cargarImagenes();
        cargarEtiquetas();
    }

    private void pasarADerrota() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sceneDerrota.fxml"));
            Parent round = loader.load();

            ResultController controller = loader.getController();
            //controller.setModelo(this.modelo);

            roundPane.getScene().setRoot(round);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void pasarATienda() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/shopScene.fxml"));
            Parent round = loader.load();

            ShopSceneController controller = loader.getController();
            controller.setModelo(this.modelo);

            roundPane.getScene().setRoot(round);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            makeTarotClickable(!selectedCards.isEmpty());
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
        for (int i = 0; i < cartas.size(); i++) {
            ICarta carta = cartas.get(i);
            PaneCarta imageView = (PaneCarta) children.get(i);
            imageView.setCarta(carta);
        }
    }
}
