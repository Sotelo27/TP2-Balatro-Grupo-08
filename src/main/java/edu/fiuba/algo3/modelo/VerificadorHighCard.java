package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerificadorHighCard extends Verificador {

    public VerificadorHighCard() {
        super();
        this.proximoVerificador = null;
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        return new HighCard(listaPuntuables);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        agregarPuntuables(cartas);
        return true;
    }

}
