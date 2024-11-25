package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;

import java.util.List;

public class FourOfAKind extends CombinacionDePoker {
    public FourOfAKind(List<CartaDePoker> cartas) {
        super(cartas);
        this.efecto = new Efecto(60,7);
        this.nombre = "poker";
    }
}
