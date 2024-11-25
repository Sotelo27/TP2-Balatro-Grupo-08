package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.IMejorador;

import java.util.*;
public class StraightFlush extends CombinacionDePoker {




    public StraightFlush(List<CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "Straight Flush";
        this.efecto = new Efecto(100,8);
    }

    @Override
    public void mejorar(IMejorador mejorador) {

    }
}
