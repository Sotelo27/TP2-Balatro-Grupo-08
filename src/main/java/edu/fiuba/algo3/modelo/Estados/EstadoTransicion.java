package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.IGameState;

import java.io.IOException;


public class EstadoTransicion extends EstadoJuego {


    public EstadoTransicion() {
    }


    @Override
    public void iniciar() throws IOException {
        this.sceneController.cambiarAEscena("/fxml/playerScene.fxml");
    }
}

