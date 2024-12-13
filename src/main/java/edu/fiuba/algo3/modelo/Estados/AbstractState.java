package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.ISwitcher;

abstract public class AbstractState {

    protected ISwitcher switcher;

    protected EstadoJuego estadoJuego;

    public AbstractState() {
    }

    abstract void render();

    abstract void actualizar(IGameState modelo);

    public void setEstado(ISwitcher switcher, EstadoJuego estadoJuego) {
        this.switcher = switcher;
        this.estadoJuego = estadoJuego;
    }
}
