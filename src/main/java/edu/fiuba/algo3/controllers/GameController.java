package edu.fiuba.algo3.controllers;
import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.repositorios.LectorDeJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
public class GameController {
    private BalatroAlgo3 modelo;
    @FXML
    private Button btnNameSaver;
    private SceneController switcher;
    @FXML
    private TextField usernameField;
    private String userName;
    public GameController(){
        switcher = new SceneController();
    }
    @FXML
    void saveName(ActionEvent event) throws IOException {
        this.userName = usernameField.getText();
        System.out.println(this.userName);
        this.modelo = new BalatroAlgo3(this.userName, new LectorDeJSON());
        // Cambiar a la escena de la tienda
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/shopScene.fxml"));
        Parent root = loader.load();
        // Configurar la nueva escena
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        // Configurar el controlador de la nueva escena para que use el modelo actual
        GameController nuevoControlador = loader.getController();
        nuevoControlador.setModelo(this.modelo);
        nuevoControlador.setUserName(this.userName);
        stage.setScene(scene);
        stage.show();
    }
    // Métodos para pasar el modelo y el nombre de usuario
    public void setModelo(BalatroAlgo3 modelo) {
        this.modelo = modelo;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @FXML
    void backToTitle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainScene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void initialize() {}
    @FXML
    void seleccionarCarta(MouseEvent event) {
        System.out.println(this.modelo.getCartasEnMano());
        Node cartaCliqueada = (Node) event.getSource();
        System.out.println(cartaCliqueada.getId());
    }
}
