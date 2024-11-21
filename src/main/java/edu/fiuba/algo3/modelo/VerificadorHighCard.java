package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerificadorHighCard extends Verificador {


    @Override
    public boolean esDeTipo(List<Carta> cartas) {
        return new
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        return new HighCard();
    }
}
