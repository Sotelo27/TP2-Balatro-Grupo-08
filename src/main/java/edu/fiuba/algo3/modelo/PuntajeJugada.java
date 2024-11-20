package edu.fiuba.algo3.modelo;

public class PuntajeJugada {
    int puntos;
    int multiplicador;
    //la idea es que reciba un tipo de jugada en base a las cartas  que tenga
    public PuntajeJugada(int puntos, int multiplicador) {

    }

    public void agregarPuntosYMultiplicador(int puntos, int multiplicador) {
        this.puntos += puntos;
        this.multiplicador += multiplicador;
    }


}
