package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.IGameState;

import java.io.IOException;


public class EstadoInicio extends EstadoJuego {


    public EstadoInicio() {
    }

    @Override
    public void iniciar() throws IOException {
        this.sceneController.cambiarAEscena("/fxml/titleScene.fxml");
    }

}

