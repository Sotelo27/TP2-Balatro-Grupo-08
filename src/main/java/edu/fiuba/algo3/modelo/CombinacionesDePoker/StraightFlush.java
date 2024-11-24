package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;

import java.util.*;
public class StraightFlush extends CombinacionDePoker {




    public StraightFlush(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 100;
        this.multiplicador = 8;
        this.nombre = "Straight Flush";

    }

}
