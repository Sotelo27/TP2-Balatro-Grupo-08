package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.IMejorador;

import java.util.List;

public class Straight extends CombinacionDePoker {
    public Straight(List <CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "Straight";
        this.efecto = new Efecto(30,4);
    }

    @Override
    public void mejorar(IMejorador mejorador) {

    }
}
