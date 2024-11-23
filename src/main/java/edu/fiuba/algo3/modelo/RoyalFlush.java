package edu.fiuba.algo3.modelo;

import java.util.List;


public class RoyalFlush extends CombinacionDePoker {



    public RoyalFlush(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 100;
        this.multiplicador = 8;
        this.nombre = "Royal Flush";
    }


};
