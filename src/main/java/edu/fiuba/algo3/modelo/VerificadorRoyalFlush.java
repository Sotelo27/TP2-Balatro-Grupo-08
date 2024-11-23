package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerificadorRoyalFlush extends Verificador {

    public VerificadorRoyalFlush() {
        super();
        this.proximoVerificador = new VerificadorStraightFlush ();
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        return false;
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)) {
            return new RoyalFlush(cartas);
        }
        return pasarAlSiguiente(cartas);

    }


}
