package edu.fiuba.algo3.modelo;

public class Puntuable extends EstadoDeCarta{

    public Puntuable(){
        this.esPuntuable = true;
    }

    @Override
    public void aplicarResultadoAPuntaje(Efecto efecto,PuntajeJugada puntajeJugada){
        efecto.aplicarEfectoAPuntaje(puntajeJugada);
    }
}

