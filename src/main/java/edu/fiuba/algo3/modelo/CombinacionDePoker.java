package edu.fiuba.algo3.modelo;

import java.util.*;

public abstract class  CombinacionDePoker {

    String nombre;
    int puntos;
    int multiplicador;
    List <Carta> cartas;

    public CombinacionDePoker(List <Carta> cartas) {
        this.cartas = cartas;
    }

    public int devolverPuntaje(){
        return this.puntos * this.multiplicador;
    }




}
