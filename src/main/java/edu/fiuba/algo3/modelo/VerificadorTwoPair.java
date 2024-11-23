package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class VerificadorTwoPair extends Verificador {
    public VerificadorTwoPair() {
        super();
        this.proximoVerificador = new VerificadorOnePair();
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        ordenarPorNumero(cartas);
        if (esDeTipo(cartas)){
            return new TwoPair(cartas);
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
                    return true;
                }
                else{primerPar = true;
                }
            }
        }
        return false;
    }


}
