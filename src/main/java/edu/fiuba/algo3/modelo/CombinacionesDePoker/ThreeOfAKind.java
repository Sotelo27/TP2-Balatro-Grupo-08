package edu.fiuba.algo3.modelo.CombinacionesDePoker;
import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;

import java.util.*;

public class ThreeOfAKind extends CombinacionDePoker {
    public ThreeOfAKind(List <CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 30;
        this.multiplicador = 3;
        this.nombre = "ThreeOfAKind";
    }
}