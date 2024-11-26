package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;

import java.util.List;

public class FullHouse extends CombinacionDePoker {
    public FullHouse(List<CartaDePoker> cartas) {
        super(cartas);
        this.efecto = new Efecto(40,4);
        this.nombre = "full";
        this.setSumaPuntos();
    }

}
