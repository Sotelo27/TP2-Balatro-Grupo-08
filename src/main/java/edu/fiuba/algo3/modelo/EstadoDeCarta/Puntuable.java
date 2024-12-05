package edu.fiuba.algo3.modelo.EstadoDeCarta;

import edu.fiuba.algo3.modelo.PuntajeJugada;

public class Puntuable extends EstadoDeCarta {

    public Puntuable(){
        this.esPuntuable = true;
    }

    @Override
    public void aplicarResultadoAPuntaje(PuntajeJugada puntajeASumar, PuntajeJugada puntajeJugada){
        puntajeJugada.sumarPuntaje(puntajeASumar);
    }

}

