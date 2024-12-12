package edu.fiuba.algo3.modelo.Estados;

import java.io.IOException;

public class EstadoCreandoPartida extends AbstractState  {

    @Override
    void render()  {
        this.switcher.cambiarAEscena("/fxml/playerScene.fxml");
    }

    @Override
    void actualizar() {
        this.estadoJuego.cambiarA(new EstadoTienda());
    }
}
