package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.PuntajeJugada;

import java.util.*;
public class StraightFlush extends CombinacionDePoker {

    public StraightFlush(List<CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "escalera de color";
        this.puntos = 100;
        this.multiplicador = 8;
    }

    public void aplicarMejora(Mejora mejora){}


}
