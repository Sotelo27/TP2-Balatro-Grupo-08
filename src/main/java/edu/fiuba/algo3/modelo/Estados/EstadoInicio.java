package edu.fiuba.algo3.modelo.Estados;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import edu.fiuba.algo3.modelo.BalatroAlgo3;


public class EstadoInicio extends EstadoJuego{


    public EstadoInicio(BalatroAlgo3 juegoBalatro, Stage escena) {

        super(juegoBalatro, escena);
    }

    @Override
    public void empezar() {

    }

    @Override
    public void terminar() {

    }

    @Override
    public void cambiar() {

    }


    public void ejecutar(BalatroAlgo3 juegoBalatro) {
        juegoBalatro.setEstado(new EstadoTienda(this.juegoBalatro, this.escena));
    }

    public boolean esEstadoFinal() {
        return false;
    }


}

