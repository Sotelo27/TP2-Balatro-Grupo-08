package edu.fiuba.algo3.modelo;

import javafx.util.Pair;

import java.util.List;

public class OnePair extends CombinacionDePoker {
    public OnePair(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre =  "OnePair";
        this.puntos = 10;
        this.multiplicador = 2;

    }

}
