package edu.fiuba.algo3.modelo;

import java.util.*;

public class  CombinacionDePoker {

    String nombre;
    int puntos;
    int multiplicador;
    List <CartaDePoker> cartas;

    public CombinacionDePoker(List <CartaDePoker> cartas) {
        this.cartas = cartas;

    }

    public void aplicarPuntajeAPuntajeJugada(PuntajeJugada puntajeJugada) {
        puntajeJugada.agregarPuntosYMultiplicador(this.puntos, this.multiplicador);

    }

    public int devolverPuntaje(){
        return this.puntos * this.multiplicador;
    }


}
