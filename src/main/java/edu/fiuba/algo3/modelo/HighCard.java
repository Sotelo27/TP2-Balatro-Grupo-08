package edu.fiuba.algo3.modelo;

import java.util.List;

public class HighCard extends CombinacionDePoker {



    public HighCard(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 5;
        this.multiplicador = 1;
        this.nombre = "High Card";
    }
}
