package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;

import java.util.List;

public class Flush extends CombinacionDePoker {

    public Flush(List<CartaDePoker> cartas) {
        super(cartas);
        this.efecto = new Efecto(35,2);
        this.nombre = "color";
    }

}
