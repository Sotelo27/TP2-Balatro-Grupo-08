package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.Flush;
import edu.fiuba.algo3.modelo.Verificador;

import java.util.List;

public class VerificadorFlush extends Verificador {

    public VerificadorFlush(){
        this.proximoVerificador = new VerificadorStraight() {
        };

    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new Flush(cartas);
        }
        else{
            return proximoVerificador.verificar(cartas);

        }
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        //que cada carta le pregunte a la siguiente que sea de igual palo
        CartaDePoker primerCarta = cartas.get(0);
        return cartas.stream().allMatch(card -> card.soyDelMismoPaloQueOtraCarta(primerCarta));
    }
}
