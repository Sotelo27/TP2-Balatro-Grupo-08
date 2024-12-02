package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;

import java.util.List;

public class Straight extends CombinacionDePoker {
    public Straight(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "escalera";
        this.puntos = 30;
        this.multiplicador = 4;
    }

    public void aplicarMejora(Mejora mejora){}
}
