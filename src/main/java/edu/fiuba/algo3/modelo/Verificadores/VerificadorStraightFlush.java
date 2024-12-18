package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.StraightFlush;

import java.util.List;

public class VerificadorStraightFlush extends Verificador {

    public VerificadorStraightFlush() {
        super();
        this.proximoVerificador = new VerificadorFourOfAKind();

    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new StraightFlush(this.listaPuntuables);
        }
        return pasarAlSiguiente(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        if (sonDelMismoTipo(cartas) && esSecuencia(cartas) && cartas.size() == 5) {
            agregarPuntuables(cartas);
            return true;
        }
        return false;
    }


}





