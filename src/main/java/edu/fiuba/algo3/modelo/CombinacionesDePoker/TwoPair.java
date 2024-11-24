package edu.fiuba.algo3.modelo.CombinacionesDePoker;
import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.IMejorador;

import java.util.*;

public class TwoPair extends CombinacionDePoker {
    public TwoPair( List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre= "Two Pair";
        this.efecto = new Efecto(20,2);

    }

    @Override
    public void mejorar(IMejorador mejorador) {

    }
}
