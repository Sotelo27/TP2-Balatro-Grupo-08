package edu.fiuba.algo3.modelo.Estados;
import edu.fiuba.algo3.controllers.TitleSceneController;
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/titleScene.fxml"));
            Parent root = loader.load();

            TitleSceneController controlador = loader.getController();

            this.escena.setScene(new Scene(root));
            this.escena.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

