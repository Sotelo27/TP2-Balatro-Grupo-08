package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;

import java.util.List;


public class RoyalFlush extends CombinacionDePoker {



    public RoyalFlush(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 100;
        this.multiplicador = 8;
        this.nombre = "Royal Flush";
    }


};
