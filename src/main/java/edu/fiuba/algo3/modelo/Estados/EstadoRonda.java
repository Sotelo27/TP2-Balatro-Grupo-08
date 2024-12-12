package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.IGameState;
import edu.fiuba.algo3.modelo.IGameState;
import javafx.stage.Stage;

import java.io.IOException;


public class EstadoRonda extends AbstractState {


    public EstadoRonda() {
    }

    @Override
    void render() throws IOException {
        this.switcher.cambiarAEscena("/fxml/roundScene.fxml");

    }

    @Override
    void actualizar() throws IOException {
        this.estadoJuego.cambiarA(new EstadoTienda() );

    }


}

