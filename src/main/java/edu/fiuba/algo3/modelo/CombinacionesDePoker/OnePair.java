package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.IMejorador;

import java.util.List;

public class OnePair extends CombinacionDePoker {
    public OnePair(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre =  "OnePair";
        this.efecto = new Efecto(10,2);
    }

    @Override
    public void mejorar(IMejorador mejorador) {

    }
}
