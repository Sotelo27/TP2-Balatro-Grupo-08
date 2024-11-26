package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;

import java.util.List;

public class HighCard extends CombinacionDePoker {

    public HighCard(List<CartaDePoker> cartas) {
        super(cartas);
        this.efecto = new Efecto(5,1);
        this.nombre = "carta alta";
        this.setSumaPuntos();
    }

}
