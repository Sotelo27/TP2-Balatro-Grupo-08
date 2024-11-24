package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.HighCard;
import edu.fiuba.algo3.modelo.Verificador;

import java.util.List;

public class VerificadorHighCard extends Verificador {



    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        return new HighCard(cartas);
    }
}
