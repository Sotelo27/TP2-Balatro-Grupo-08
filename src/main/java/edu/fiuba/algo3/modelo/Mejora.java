package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mejoras.*;
public class Mejora{

    private int puntos;
    private int multiplicador;
    private IMejora mejora;

    public Mejora() {
        this.puntos = 0;
        this.multiplicador = 0;
        this.mejora = new NoHaceNada();
    }

    public Mejora(int puntos, int multiplicador, IMejora mejora){
        this.puntos = puntos;
        this.multiplicador = multiplicador;
        this.mejora = mejora;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }
    public void setMejora(IMejora mejora) {
        this.mejora = mejora;
    }


    public void seAplicaAPuntaje(PuntajeJugada puntajeJugada){
        this.mejora.seAplicaApuntaje(puntajeJugada, this.puntos, this.multiplicador);
    }

    public void aniadirMejora(IMejora mejora) {
        this.mejora = mejora;
    }

    public void seAplicaApuntaje(PuntajeJugada puntaje) {
        this.mejora.seAplicaApuntaje(puntaje, this.puntos, this.multiplicador);
    }
}
