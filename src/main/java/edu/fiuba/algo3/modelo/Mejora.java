package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mejoras.*;
public class Mejora{ 

    private int puntos;
    private int multiplicador;
    private IMejora mejora;

    public Mejora() {}

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
        //this.mejora.seAplicaAPuntaje(puntaje, this.puntos, this.multiplicador);
    }



}
