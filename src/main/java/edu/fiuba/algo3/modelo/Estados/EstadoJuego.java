package edu.fiuba.algo3.modelo.Estados;
import edu.fiuba.algo3.controllers.SceneController;
import edu.fiuba.algo3.modelo.IGameState;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observer;

public abstract class EstadoJuego {
    protected IGameState gameState;
    protected SceneController sceneController;
    protected EstadoJuego estadoActual;

    public void setSwitcher(SceneController switcher){
        this.sceneController = switcher;
    }

    public void setModel(IGameState modelo){
        this.gameState = modelo;
    }

    public abstract void iniciar() throws IOException;

    public void cambiarA(EstadoJuego nuevoEstado) {
        this.estadoActual = nuevoEstado;
        estadoActual.setSwitcher(sceneController);
        estadoActual.setModel(this.gameState);
    }
}
