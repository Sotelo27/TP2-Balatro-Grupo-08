package edu.fiuba.algo3.modelo.CombinacionesDePoker;
import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.IMejorador;

import java.util.*;

public class ThreeOfAKind extends CombinacionDePoker {
    public ThreeOfAKind(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "ThreeOfAKind";
        this.efecto = new Efecto(30,3);
    }

    @Override
    public void mejorar(IMejorador mejorador) {

    }
}
