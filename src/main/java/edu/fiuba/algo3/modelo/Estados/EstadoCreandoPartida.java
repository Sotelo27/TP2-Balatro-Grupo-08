package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;

public class EstadoCreandoPartida extends AbstractState  {

    @Override
    void render()  {
        this.switcher.cambiarAEscena("/fxml/playerScene.fxml");
    }

    @Override
    void actualizar(IGameState modelo) {
        this.estadoJuego.cambiarA(new EstadoTienda());
    }
}
