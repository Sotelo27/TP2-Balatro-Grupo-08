package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.ISwitcher;

public class EstadoJuego {
    private IGameState gameState;

    private AbstractState estadoActual;
    private final ISwitcher switcher;

    public EstadoJuego(ISwitcher switcher, AbstractState estadoInicial) {
        this.switcher = switcher;
        this.estadoActual = estadoInicial;
        estadoInicial.setEstado(this.switcher, this);
    }

    public void setModel(IGameState modelo){
        this.gameState = modelo;
    }

    public void cambiarA(AbstractState nuevoEstado){
        this.estadoActual = nuevoEstado;
        nuevoEstado.setEstado(this.switcher, this);
        estadoActual.render();
    }


    public void render() {
        this.estadoActual.render();
    }

    public void actualizar(IGameState modelo) {
        this.estadoActual.actualizar(modelo);
    }

    public void terminar() {
        this.switcher.cambiarAEscena("/fxml/titleScene.fxml");
    }

    public void reiniciar() {
        this.switcher.cambiarAEscena("/fxml/playerScene.fxml");
    }

}
