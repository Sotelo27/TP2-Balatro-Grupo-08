package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.Balatro;

public abstract class EstadoJuego {
    protected Balatro juegoBalatro;


    public EstadoJuego(Balatro juegoBalatro) {
        this.juegoBalatro = juegoBalatro;
    }
    public abstract void mostrar();

    public abstract void quedanRondas();

    public abstract void noQuedanRondas();







}
