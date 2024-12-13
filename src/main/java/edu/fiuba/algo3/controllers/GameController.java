package edu.fiuba.algo3.controllers;
import edu.fiuba.algo3.modelo.BalatroAlgo3;
import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.IModelo;
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
public abstract class GameController {
    protected IModelo modelo;

    // Métodos para pasar el modelo y el nombre de usuario
    public void setModelo(IModelo modelo) {
        this.modelo = modelo;
    }


}
