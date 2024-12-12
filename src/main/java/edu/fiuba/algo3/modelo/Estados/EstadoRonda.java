package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;

import java.io.IOException;


public class EstadoRonda extends AbstractState {


    public EstadoRonda() {
    }

    @Override
    void render()  {
        this.switcher.cambiarAEscena("/fxml/roundScene.fxml");
    }

    @Override
    void actualizar(IGameState modelo) {
        if (modelo.ganoJuego()) {
            this.estadoJuego.cambiarA(new EstadoVictoria());

        } else if (modelo.perdioRonda()){
            this.estadoJuego.cambiarA(new EstadoDerrota() );

        } else if (modelo.rondaSuperada()){
            this.estadoJuego.cambiarA(new EstadoTransicion() );
        }
    }

}

