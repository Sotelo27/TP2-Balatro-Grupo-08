package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.IGameState;

import java.io.IOException;


public class EstadoTienda extends AbstractState  {


    public EstadoTienda() {
    }

    @Override
    void render() throws IOException {
        this.switcher.cambiarAEscena("/fxml/shopScene.fxml");
    }

    @Override
    void actualizar() throws IOException {
        this.estadoJuego.cambiarA(new EstadoRonda() );

    }


}

