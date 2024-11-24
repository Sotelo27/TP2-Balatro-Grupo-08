package edu.fiuba.algo3.modelo.CombinacionesDePoker;
import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;

import java.util.*;

public class TwoPair extends CombinacionDePoker {
    public TwoPair( List <CartaDePoker> cartas) {
        super(cartas);
        this.puntos= 20;
        this.multiplicador = 2 ;
        this.nombre= "Two Pair";

    }
}
