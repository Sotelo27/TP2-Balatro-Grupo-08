package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;

import java.io.IOException;

public class EstadoVictoria extends AbstractState {
    @Override
    void render() {
        this.switcher.cambiarAEscena("/fxml/victoryScene.fxml");

    }

    @Override
    void actualizar(IGameState modelo) {
        this.estadoJuego.cambiarA(new EstadoInicio());
    }
}
