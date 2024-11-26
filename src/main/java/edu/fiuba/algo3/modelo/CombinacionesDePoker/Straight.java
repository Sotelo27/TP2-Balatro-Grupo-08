package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;

import java.util.List;

public class Straight extends CombinacionDePoker {
    public Straight(List <CartaDePoker> cartas) {
        super(cartas);
        this.efecto = new Efecto(30,4);
        this.nombre = "escalera";
        this.setSumaPuntos();
    }

}
