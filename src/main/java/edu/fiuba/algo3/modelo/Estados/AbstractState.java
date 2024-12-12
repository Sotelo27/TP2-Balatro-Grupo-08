package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.controllers.SceneManager;
import edu.fiuba.algo3.modelo.IGameState;

import java.io.IOException;

abstract public class AbstractState {

    protected SceneManager switcher;

    protected EstadoJuego estadoJuego;

    public AbstractState() {
    }

    abstract void render();

    abstract void actualizar(IGameState modelo);

    public void setEstado(SceneManager switcher, EstadoJuego estadoJuego) {
        this.switcher = switcher;
        this.estadoJuego = estadoJuego;
    }
}
