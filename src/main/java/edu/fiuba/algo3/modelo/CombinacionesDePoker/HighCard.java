package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.PuntajeJugada;

import java.util.List;

public class HighCard extends CombinacionDePoker {

    public HighCard(List<CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "carta alta";
        this.puntos = 5;
        this.multiplicador = 1;
    }

    public void aplicarMejora(Mejora mejora){}
}
