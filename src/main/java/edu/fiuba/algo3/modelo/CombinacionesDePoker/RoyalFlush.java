package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.PuntajeJugada;

import java.util.List;


public class RoyalFlush extends CombinacionDePoker {



    public RoyalFlush(List<CartaDePoker> cartas) {
        super(cartas);
        this.puntaje = new PuntajeJugada(100,8);
        this.nombre = "escalera real";
        this.puntos = 100;
        this.multiplicador = 8;
    }
    public void aplicarMejora(Mejora mejora){}


};
