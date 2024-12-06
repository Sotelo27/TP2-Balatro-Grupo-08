package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.TwoPair;

import java.util.List;
import java.util.Map;

public class VerificadorTwoPair extends Verificador {
    public VerificadorTwoPair() {
        super();
        this.proximoVerificador = new VerificadorOnePair();
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new TwoPair(this.listaPuntuables);
        }
        return pasarAlSiguiente(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        boolean primerPar = false;
        boolean segundoPar = false;
        Map<List<CartaDePoker>, Integer> gruposDeCoincidenciasNumero = contarPorNumero(cartas);
        for (Map.Entry<List<CartaDePoker>, Integer> entry : gruposDeCoincidenciasNumero.entrySet()){
            if (entry.getValue() == 2){
                if (primerPar){
                    segundoPar = true;
                }
                else{primerPar = true;
                }
                agregarPuntuables(entry.getKey());
            }
            else {
                this.listaPuntuables.addAll(entry.getKey());
            }

        }
        return (segundoPar && primerPar);
    }


}
