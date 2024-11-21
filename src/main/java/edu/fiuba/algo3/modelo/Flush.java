package edu.fiuba.algo3.modelo;

import java.util.List;

public class Flush extends CombinacionDePoker{

    public Flush(List<CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "Flush";
        this.puntos = 35;
        this.multiplicador = 4;
    }
}
