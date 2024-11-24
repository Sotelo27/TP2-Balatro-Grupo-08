package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.IMejorador;
import edu.fiuba.algo3.modelo.Mejora;

import java.util.List;

public class FourOfAKind extends CombinacionDePoker {
    public FourOfAKind(List<CartaDePoker> cartas) {
        super(cartas);
        this.efecto = new Efecto(60,7);
        this.nombre = "FourOfAKind";
    }

    @Override
    public void mejorar(IMejorador mejorador) {

    }
}
