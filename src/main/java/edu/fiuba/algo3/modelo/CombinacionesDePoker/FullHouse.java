package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.PuntajeJugada;

import java.util.List;

public class FullHouse extends CombinacionDePoker {
    public FullHouse(List<CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "full";
        this.puntos = 40;
        this.multiplicador = 4;
    }
    public void aplicarMejora(Mejora mejora){}
}
