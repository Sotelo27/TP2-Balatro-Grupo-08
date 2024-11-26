package edu.fiuba.algo3.modelo.CombinacionesDePoker;
import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Mejora;

import java.util.*;

public class TwoPair extends CombinacionDePoker {
    public TwoPair( List <CartaDePoker> cartas) {
        super(cartas);
        this.efecto = new Efecto(20,2);
        this.nombre= "doble par";
        this.setSumaPuntos();
    }
    public void aplicarMejora(Mejora mejora){};
}
