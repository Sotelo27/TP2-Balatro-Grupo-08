package edu.fiuba.algo3.modelo;

import java.util.List;

public class FourOfAKind extends CombinacionDePoker{
    public FourOfAKind(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 60;
        this.multiplicador = 7 ;
        this.nombre = "FourOfAKind";
    }
}
