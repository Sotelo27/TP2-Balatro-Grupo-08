package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.Straight;

import java.util.List;

public class VerificadorStraight extends Verificador {

    public VerificadorStraight() {
        super();
        this.proximoVerificador = new VerificadorThreeOfAKind();
    };

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        ordenarPorNumero(cartas);

        if (esDeTipo(cartas)){
            return new Straight(this.listaPuntuables);
        }
        return pasarAlSiguiente(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        if (esSecuencia(cartas)){
            agregarPuntuables(cartas);
            return true;
        }
        return false;
    }


}
