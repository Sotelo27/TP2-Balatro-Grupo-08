package edu.fiuba.algo3.modelo;

public class PuntajeJugada {
    int puntos;
    int multiplicador;
    //la idea es que reciba un tipo de jugada en base a las cartas  que tenga
    public PuntajeJugada( ) {

    }

    public void agregarPuntosYMultiplicador(int puntos, int multiplicador) {
        this.puntos += puntos;
        this.multiplicador += multiplicador;
    }
    public void calcularPuntosCombinacion(){

    }

    public int getPuntos() {
        return this.puntos * this.multiplicador;
    }

}
