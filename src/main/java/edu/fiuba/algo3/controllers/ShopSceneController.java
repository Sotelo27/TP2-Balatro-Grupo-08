package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.ICarta;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShopSceneController implements Initializable {

    @FXML
    public AnchorPane shopPane;

    public TilePane tarotsGuardados;
    public Text nombreObjeto;
    public Text descripcionObjeto;

    @FXML ImageView choosedCard;

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
    private Integer selectedCard;
    private static final double SCALE_FACTOR = 1.1; // 10% más grande

    void setBehaviour(ImageView card, int selectedPos){
        card.setOnMouseEntered(e -> {
            this.agrandarImagen(card);
            this.selectedCard = selectedPos;
            preSeleccionar(card);
        });
        card.setOnMouseExited(e -> {
            this.achicarImagen(card);
        });
        card.setOnMouseClicked(e -> {
            System.out.println(selectedPos);
        });
    }

    @FXML
    void selectFirstCard(MouseEvent event)  {
        //comprarCarta(1);
        System.out.println("firstCardOffert selected");
        this.setBehaviour(firstCardOffert, 0);
    }

    @FXML
    void selectScndCard(MouseEvent event) {
        //comprarCarta(2);
        System.out.println("scndCardOffert selected");
        this.setBehaviour(scndCardOffert, 1);
    }

    @FXML
    void selectThirdCard(MouseEvent event) {
        //comprarCarta(3);
        System.out.println("thirdCardOffert selected");
        this.setBehaviour(thrdCardOffert, 2);
    }

    @FXML
    void selectFourthCard(MouseEvent event){
        //comprarCarta(4);
        System.out.println("fourthCardOffert selected");
        this.setBehaviour(fourthCardOffert, 3);
    }

    @FXML
    void selectFifthCard(MouseEvent event) {
        //comprarCarta(5);
        System.out.println("fifthCardOffert selected");
        this.setBehaviour(fifthCardOffert, 4);
    }

    public void setModelo(BalatroAlgo3 modelo) {
        this.modelo = modelo;
        cargarItemsDeTienda();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.selectedCard = 0;
         // Escucha los cambios de tamaño del VBox
         shopPane.layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
             Stage stage = (Stage) shopPane.getScene().getWindow();
             stage.sizeToScene();
         });
    }

    private void cargarItemsDeTienda() {
        List<ICarta> items = modelo.getCartasDeTienda();
        Integer pos = 0;
        List<javafx.scene.Node> children = cardOffersPane.getChildren();
        for ( ICarta item : items ) {
            ImageView imageView = (ImageView) children.get(pos);
            imageView.setImage(new Image(getResourcePath(item.getImagen()) ));
            pos ++;
        }
    }

    private InputStream getResourcePath(String path) {
        System.out.println(path);
        InputStream file = getClass().getResourceAsStream(path);
        if (file == null) {
            return getClass().getResourceAsStream("/images/cartas/2 de Corazones.png");
        }
        return file ;
    }

    private void preSeleccionar(ImageView cardOffert) {
        this.choosedCard.setImage(cardOffert.getImage());
        this.nombreObjeto.setText(this.modelo.getCartasDeTienda().get(selectedCard).getNombre());
        this.descripcionObjeto.setText(this.modelo.getCartasDeTienda().get(selectedCard).getDescripcion());
    }

    private void comprarCarta(int posicion) throws IOException {
        ICarta carta = modelo.getCartasDeTienda().get(posicion-1);
        modelo.seleccionarCartaDeTienda(carta);
        goNextStage();
    }

    private void goNextStage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RoundScene.fxml"));
            Parent round = loader.load();

            RoundSceneController controller = loader.getController();
            controller.setModelo(this.modelo);

            shopPane.getScene().setRoot(round);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void comprarCarta(MouseEvent mouseEvent) throws IOException {
        ICarta carta = modelo.getCartasDeTienda().get(this.selectedCard);
        modelo.seleccionarCartaDeTienda(carta);
        goNextStage();
    }

    private void achicarImagen(ImageView cardImage) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(100), cardImage);
        scale.setToY(SCALE_FACTOR);
        scale.setToX(SCALE_FACTOR);
        scale.play();
    }

    private void agrandarImagen(ImageView cardImage) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(100), cardImage);
        scale.setToX(1);
        scale.setToY(1);
        scale.play();
    }
}
