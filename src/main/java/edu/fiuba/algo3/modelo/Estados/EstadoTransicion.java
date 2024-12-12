package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;


public class EstadoTransicion extends AbstractState {


    public EstadoTransicion() {
    }

    @Override
    void render() {
        this.switcher.cambiarAEscena("/fxml/transitionScene.fxml");
    }

    @Override
    void actualizar(IGameState modelo)  {
        this.estadoJuego.cambiarA(new EstadoTienda() );
    }

}

