package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.*;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.PuntajeJugada;

import java.util.List;

public class OnePair extends CombinacionDePoker {
    public OnePair(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre =  "par";
        this.puntos = 10;
        this.multiplicador = 2;
    }
    public void aplicarMejora(Mejora mejora){}

}
