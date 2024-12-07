package edu.fiuba.algo3.modelo.Estados;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import edu.fiuba.algo3.modelo.BalatroAlgo3;

public abstract class EstadoJuego {
    protected BalatroAlgo3 juegoBalatro;
    protected Stage escena;


    public EstadoJuego(BalatroAlgo3 juegoBalatro, Stage escena) {
        this.juegoBalatro = juegoBalatro;
        this.escena = escena;
    }

    public abstract void empezar();
    public abstract void terminar();
    public abstract void cambiar();





}
