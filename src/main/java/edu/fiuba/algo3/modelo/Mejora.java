package edu.fiuba.algo3.modelo;

public class Mejora {
    private int puntos;
    private int multiplicador;

    public Mejora(int puntos, int multiplicador) {
        this.puntos = puntos;
        this.multiplicador = multiplicador;
    }

    public void seAplicaAPuntaje(PuntajeJugada puntajeJugada){
        puntajeJugada.agregarPuntosYMultiplicador(this.puntos, this.multiplicador);
    }


}
