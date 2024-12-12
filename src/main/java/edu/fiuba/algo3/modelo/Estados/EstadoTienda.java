package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;


public class EstadoTienda extends AbstractState  {


    public EstadoTienda() {
    }

    @Override
    void render()  {
        this.switcher.cambiarAEscena("/fxml/shopScene.fxml");
    }

    @Override
    void actualizar(IGameState modelo){
        this.estadoJuego.cambiarA(new EstadoRonda() );

    }


}

