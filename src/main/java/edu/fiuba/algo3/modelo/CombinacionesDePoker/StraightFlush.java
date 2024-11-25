package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;

import java.util.*;
public class StraightFlush extends CombinacionDePoker {




    public StraightFlush(List<CartaDePoker> cartas) {
        super(cartas);
        this.efecto = new Efecto(100,8);
        this.nombre = "escalera de color";

    }


}
