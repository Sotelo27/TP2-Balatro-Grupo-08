package edu.fiuba.algo3.modelo;

import java.util.*;
public class StraightFlush extends CombinacionDePoker {




    public StraightFlush(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 100;
        this.multiplicador = 8;
        this.nombre = "Straight Flush";

    }

}
