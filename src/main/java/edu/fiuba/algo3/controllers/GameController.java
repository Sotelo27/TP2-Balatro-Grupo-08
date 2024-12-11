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
    private SceneController sceneController = new SceneController();

    @FXML
    private Button btnNameSaver;
    @FXML
    private TextField usernameField;

    private String userName;

    public GameController() {}

    @FXML
    void saveName(ActionEvent event) throws IOException {
        initializeModelo();
        switchScene(event, "/fxml/shopScene.fxml");
    }

    @FXML
    void backToTitle(ActionEvent event) throws IOException {
        switchScene(event, "/fxml/mainScene.fxml");
    }

    @FXML
    void seleccionarCarta(MouseEvent event) {
        System.out.println(this.modelo.getCartasEnMano());
        Node cartaCliqueada = (Node) event.getSource();
        System.out.println(cartaCliqueada.getId());
    }

    private void initializeModelo() throws IOException {
        this.userName = usernameField.getText();
        System.out.println(this.userName);
        this.modelo = new BalatroAlgo3(this.userName, new LectorDeJSON());
    }

    private void switchScene(ActionEvent event, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();

        GameController nuevoControlador = loader.getController();
        nuevoControlador.setModelo(this.modelo);
        nuevoControlador.setUserName(this.userName);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void setModelo(BalatroAlgo3 modelo) {
        this.modelo = modelo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

