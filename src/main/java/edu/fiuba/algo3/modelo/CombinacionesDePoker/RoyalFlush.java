package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Mejora;

import java.util.List;


public class RoyalFlush extends CombinacionDePoker {



    public RoyalFlush(List<CartaDePoker> cartas) {
        super(cartas);
        this.efecto = new Efecto(100,8);
        this.nombre = "escalera real";
        this.setSumaPuntos();
    }
    public void aplicarMejora(Mejora mejora){}


};
