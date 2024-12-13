package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;

public class EstadoDerrota extends AbstractState {
    @Override
    void render() {
        this.switcher.cambiarAEscena("/fxml/defeatScene.fxml");
    }

    @Override
    void actualizar(IGameState modelo) {
        this.estadoJuego.cambiarA(new EstadoInicio());
    }
}
