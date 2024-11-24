package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;

import java.util.List;

public class FourOfAKind extends CombinacionDePoker {
    public FourOfAKind(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 60;
        this.multiplicador = 7 ;
        this.nombre = "FourOfAKind";
    }
}
