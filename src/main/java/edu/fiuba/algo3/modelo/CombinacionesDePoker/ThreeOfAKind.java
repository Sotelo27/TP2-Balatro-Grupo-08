package edu.fiuba.algo3.modelo.CombinacionesDePoker;
import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;

import java.util.*;

public class ThreeOfAKind extends CombinacionDePoker {
    public ThreeOfAKind(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "trio";
        this.puntos = 30;
        this.multiplicador = 3;
    }
    public void aplicarMejora(Mejora mejora){}
}
