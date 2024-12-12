package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.IGameState;
import javafx.stage.Stage;

import java.io.IOException;


public class EstadoInicio extends AbstractState {

    public EstadoInicio() {
    }


    @Override
    void render() {
        this.switcher.cambiarAEscena("/fxml/titleScene.fxml");
        this.switcher.setBackgroundMusic("/sounds/MainTheme.mp3");
    }

    @Override
    void actualizar() {
        this.estadoJuego.cambiarA(new EstadoCreandoPartida() );
    }
}

