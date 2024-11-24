package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;

import java.util.List;

public class Straight extends CombinacionDePoker {
    public Straight(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "Straight";
    }
}
