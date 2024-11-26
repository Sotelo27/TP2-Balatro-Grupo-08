package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Efecto{
    private int puntos;
    private int multiplicador;
    private List<Mejora> mejoras;

    public Efecto() {
        this.puntos = 0;
        this.multiplicador = 0;
        this.mejoras = new ArrayList<>();
    }

    public Efecto(int puntos) {
        this.puntos = puntos;
        this.multiplicador = 0;
        this.mejoras = new ArrayList<>();
    }

    public Efecto(int puntos, int multiplicador) {
        this.puntos = puntos;
        this.multiplicador = multiplicador;
        this.mejoras = new ArrayList<>();
    }


    public void recibirMejora(Mejora mejora) {
        this.mejoras.add(mejora);
    }
    public void setMejora(Mejora mejora){
        this.mejora = mejora;
    }

    public void aplicarAPuntaje(PuntajeJugada puntajeJugada){
        for(Mejora mejora : mejoras){
            mejora.seAplicaAPuntaje(puntajeJugada);

        }
    }
}
