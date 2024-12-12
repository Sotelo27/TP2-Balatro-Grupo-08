package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.IGameState;

import java.io.IOException;


public class EstadoTransicion extends AbstractState {


    public EstadoTransicion() {
    }

    @Override
    void render() {
        this.switcher.cambiarAEscena("/fxml/playerScene.fxml");
    }

    @Override
    void actualizar() throws IOException {
        this.estadoJuego.cambiarA(new EstadoTienda() );
    }

}

