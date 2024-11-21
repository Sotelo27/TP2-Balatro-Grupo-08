package edu.fiuba.algo3.modelo;

import java.util.List;


public class RoyalFlush extends CombinacionDePoker {
    String nombre;
    int puntos;
    int multiplicador;
    List <Carta> cartas;


    public RoyalFlush(List<Carta> cartas) {
        super(cartas);
    }
}
