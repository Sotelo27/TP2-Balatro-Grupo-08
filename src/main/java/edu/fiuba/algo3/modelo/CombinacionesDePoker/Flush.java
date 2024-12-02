package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;

import java.util.List;

public class Flush extends CombinacionDePoker {

    public Flush(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 35;
        this.multiplicador = 2;
        this.nombre = "color";
    }

    public void aplicarMejora(Mejora mejora){}

}
