package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.Balatro;

public class EstadoTienda extends EstadoJuego {
    public EstadoTienda(Balatro balatro) {
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
