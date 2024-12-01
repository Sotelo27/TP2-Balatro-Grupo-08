package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mejoras.IMejora;

import java.util.ArrayList;
import java.util.List;

public class Efecto{
    private int puntos;
    private int multiplicador;
    private List<Mejora> mejoras;

    public Efecto() {
        this.puntos = 0;
        this.multiplicador = 1;
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

    public void setMejora(IMejora mejora){
        this.mejoras.get(0).aniadirMejora(mejora);
    }



    public void aplicarAPuntaje(PuntajeJugada puntajeJugada){
        //puntajeJugada.sumarAMultiplicador(this.multiplicador);
        for(Mejora mejora : mejoras){
            mejora.seAplicaAPuntaje(puntajeJugada);

        }
    }
}
