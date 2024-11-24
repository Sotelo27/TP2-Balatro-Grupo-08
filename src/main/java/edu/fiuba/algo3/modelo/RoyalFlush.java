package edu.fiuba.algo3.modelo;

import java.util.List;


public class RoyalFlush extends CombinacionDePoker {
    private String nombre;
    private Efecto Efecto;
    List <CartaDePoker> cartas;


    public RoyalFlush(List<CartaDePoker> cartas) {
        super(cartas);
    }
}
