package edu.fiuba.algo3.modelo;

public class Mejora {
    private int sumarPuntos;
    private int sumarMultiplicador;
    private int multMultiplicador;

    public Mejora(int puntos, int multiplicador, int multMultiplicador) {
        this.sumarPuntos = puntos;
        this.sumarMultiplicador = multiplicador;
        this.multMultiplicador = multMultiplicador;
    }

    public void seAplicaAPuntaje(PuntajeJugada puntajeJugada){
        puntajeJugada.agregarPuntosYMultiplicador(this.sumarPuntos, this.sumarMultiplicador);
        puntajeJugada.multiplicarMultiplicador(this.multMultiplicador);
    }



}
