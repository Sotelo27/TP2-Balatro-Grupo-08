package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.PuntajeJugada;

import java.util.List;

public class FourOfAKind extends CombinacionDePoker {
    public FourOfAKind(List<CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "poker";
        this.puntos = 60;
        this.multiplicador = 7;
    }
    public void aplicarMejora(Mejora mejora){}

}
