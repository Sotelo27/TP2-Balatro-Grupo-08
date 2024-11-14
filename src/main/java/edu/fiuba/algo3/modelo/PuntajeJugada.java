package edu.fiuba.algo3.modelo;

public class PuntajeJugada {
    int puntos;
    int multiplicador;
    //la idea es que reciba un tipo de jugada en base a las cartas  que tenga
    public PuntajeJugada(int puntos, int multiplicador) {

    }

    public void sumarPuntos(int puntos){
        this.puntos += puntos;
    }

    public void sumarMultiplicador(int multiplicador){
        this.multiplicador += multiplicador;
    }
}
