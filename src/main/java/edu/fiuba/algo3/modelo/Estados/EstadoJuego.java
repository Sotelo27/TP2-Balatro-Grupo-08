package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.controllers.SceneManager;
import edu.fiuba.algo3.modelo.IGameState;

import java.io.IOException;

public class EstadoJuego {
    private IGameState gameState;

    private AbstractState estadoActual;
    private final SceneManager switcher;

    public EstadoJuego(SceneManager switcher, AbstractState estadoInicial) {
        this.switcher = switcher;
        this.estadoActual = estadoInicial;
        estadoInicial.setEstado(this.switcher, this);
    }

    public void setModel(IGameState modelo){
        this.gameState = modelo;
    }

    public void cambiarA(AbstractState nuevoEstado){

        try {
            this.estadoActual = nuevoEstado;
            nuevoEstado.setEstado(this.switcher, this);
            estadoActual.render();
        } catch (IOException e) {
            System.out.println("Error al cambiar el estado");
            throw new RuntimeException(e);
        }
    }


    public void render() {

        try {
            this.estadoActual.render();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizar() {

        try {
            this.estadoActual.actualizar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void terminar() {
        this.switcher.close();
    }

    public void reiniciar() {
        this.switcher.cambiarAEscena("/fxml/titleScene.fxml");
    }
}
