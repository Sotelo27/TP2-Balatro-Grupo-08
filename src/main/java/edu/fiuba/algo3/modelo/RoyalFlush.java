package edu.fiuba.algo3.modelo;

import java.util.List;


public class RoyalFlush extends CombinacionDePoker {
    String nombre;
    int puntos;
    int multiplicador;
    List <CartaDePoker> cartas;


    public RoyalFlush(List<CartaDePoker> cartas) {
        super(cartas);
    }
}
