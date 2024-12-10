package edu.fiuba.algo3.modelo.Mejoras;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class Mejora{

    @JsonProperty("puntos")
    private float puntos;
    @JsonProperty("multiplicador")
    private float multiplicador;
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

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    public void setMultiplicador(float multiplicador) {
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
