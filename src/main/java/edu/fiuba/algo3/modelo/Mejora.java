package edu.fiuba.algo3.modelo;

public class Mejora {

    private int puntos;
    private int multiplicador;

    public Mejora() {}

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public void seAplicaAPuntaje(PuntajeJugada puntajeJugada){
        puntajeJugada.agregarPuntosYMultiplicador(this.puntos, this.multiplicador);

    }



}
