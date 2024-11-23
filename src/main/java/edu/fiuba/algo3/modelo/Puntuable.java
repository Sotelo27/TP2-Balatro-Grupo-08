package edu.fiuba.algo3.modelo;

public class Puntuable extends EstadoDeCarta{

    @Override
    public void aplicarResultadoAPuntaje(Efecto efecto,PuntajeJugada puntajeJugada){
        efecto.calcularPuntajeCarta(puntajeJugada);
    }
}