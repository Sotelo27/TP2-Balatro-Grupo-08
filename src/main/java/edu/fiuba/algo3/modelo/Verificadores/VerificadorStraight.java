package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.Straight;
import edu.fiuba.algo3.modelo.Verificador;

import java.util.List;

public class VerificadorStraight extends Verificador {

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        return super.verificar(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        return super.esDeTipo(cartas);
    }
}
