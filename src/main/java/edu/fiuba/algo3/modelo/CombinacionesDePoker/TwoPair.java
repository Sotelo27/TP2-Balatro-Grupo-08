package edu.fiuba.algo3.modelo.CombinacionesDePoker;
import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.PuntajeJugada;

import java.util.*;

public class TwoPair extends CombinacionDePoker {
    public TwoPair( List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre= "doble par";
        this.puntos = 20;
        this.multiplicador = 2;
    }
    public void aplicarMejora(Mejora mejora){};
}
