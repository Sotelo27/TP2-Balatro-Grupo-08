package edu.fiuba.algo3.modelo;
import java.util.*;

public class ThreeOfAKind extends CombinacionDePoker {
    public ThreeOfAKind(List <CartaDePoker> cartas) {
        super(cartas);
        this.puntos = 30;
        this.multiplicador = 3;
        this.nombre = "ThreeOfAKind";
    }
}
