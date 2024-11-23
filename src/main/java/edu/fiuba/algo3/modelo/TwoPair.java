package edu.fiuba.algo3.modelo;
import java.util.*;

public class TwoPair extends CombinacionDePoker {
    public TwoPair( List <CartaDePoker> cartas) {
        super(cartas);
        this.puntos= 20;
        this.multiplicador = 2 ;
        this.nombre= "Two Pair";

    }
}
