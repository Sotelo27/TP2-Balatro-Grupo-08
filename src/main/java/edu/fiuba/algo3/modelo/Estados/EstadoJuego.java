package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.BalatroAlgo3;

public abstract class EstadoJuego {
    protected BalatroAlgo3 juegoBalatro;


    public EstadoJuego(BalatroAlgo3 juegoBalatro) {
        this.juegoBalatro = juegoBalatro;
    }
    public abstract void mostrar();

    public abstract void quedanRondas();

    public abstract void noQuedanRondas();



}
