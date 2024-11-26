package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.BalatroAlgo3;

public class EstadoTienda extends EstadoJuego {
    public EstadoTienda(BalatroAlgo3 balatro) {
        super(balatro);
    }

    @Override
    public void mostrar() {
    }

    @Override
    public void quedanRondas() {
        juegoBalatro.setEstado(new EstadoRonda(this.juegoBalatro));
    }

    @Override
    public void noQuedanRondas() {

    }


}
