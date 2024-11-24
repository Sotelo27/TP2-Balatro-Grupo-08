package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;

import java.util.List;

public class FullHouse extends CombinacionDePoker {
    public FullHouse(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 40;
        this.multiplicador = 4;
        this.nombre = "Full House";
    }
}
