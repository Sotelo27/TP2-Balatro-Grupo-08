package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.controllers.SceneController;

import java.io.IOException;

abstract public class AbstractState {

    protected SceneController switcher;

    protected EstadoJuego estadoJuego;

    public AbstractState() {
    }

    abstract void render() throws IOException;

    abstract void actualizar() throws IOException;

    public void setEstado(SceneController switcher, EstadoJuego estadoJuego) {
        this.switcher = switcher;
        this.estadoJuego = estadoJuego;
    }
}
