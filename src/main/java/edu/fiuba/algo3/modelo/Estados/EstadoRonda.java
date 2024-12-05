package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.BalatroAlgo3;

public class EstadoRonda extends EstadoJuego{
    public EstadoRonda(BalatroAlgo3 juego) {
        super(juego);
    }

    @Override
    public void mostrar() {

    }

    @Override
    public void quedanRondas() {
        juegoBalatro.setEstado(new EstadoTransicion(this.juegoBalatro));
    }

    @Override
    public void noQuedanRondas() {
        juegoBalatro.setEstado(new EstadoTransicion(this.juegoBalatro));
    }

}
