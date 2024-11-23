package edu.fiuba.algo3.modelo;

import java.util.List;

public class Straight extends CombinacionDePoker{
    public Straight(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "Straight";
    }
}
