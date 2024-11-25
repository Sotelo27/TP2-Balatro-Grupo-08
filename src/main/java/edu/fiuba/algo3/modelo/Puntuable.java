package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Estados.EstadoDeCarta;

public class Puntuable extends EstadoDeCarta {

    public Puntuable(){
        this.esPuntuable = true;
    }

    @Override
    public void aplicarResultadoAPuntaje(Efecto efecto,PuntajeJugada puntajeJugada){
        //efecto.aplicarEfectoAPuntaje(puntajeJugada);
    }
}

