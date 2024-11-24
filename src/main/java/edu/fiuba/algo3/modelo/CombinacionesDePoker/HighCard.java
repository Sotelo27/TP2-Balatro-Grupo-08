package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;

import java.util.List;

public class HighCard extends CombinacionDePoker {

    public HighCard(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 5;
        this.multiplicador = 1;
        this.nombre = "High Card";
    }
}
