package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.*;
import edu.fiuba.algo3.modelo.Efecto;

import java.util.List;

public class OnePair extends CombinacionDePoker {
    public OnePair(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre =  "par";
        this.efecto = new Efecto(10,2);
    }


}
