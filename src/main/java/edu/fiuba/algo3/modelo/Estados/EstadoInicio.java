package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.IGameState;
import javafx.stage.Stage;

import java.io.IOException;


public class EstadoInicio extends AbstractState {


    private EstadoJuego estadoActual;

    public EstadoInicio() {
    }


    @Override
    void render() {
        this.switcher.cambiarAEscena("/fxml/titleScene.fxml");
    }

    @Override
    void actualizar() throws IOException {
        this.estadoJuego.cambiarA(new EstadoTransicion() );
    }
}

