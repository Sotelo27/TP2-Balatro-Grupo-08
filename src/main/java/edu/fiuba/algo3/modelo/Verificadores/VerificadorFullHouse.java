package edu.fiuba.algo3.modelo.Verificadores;
import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.FullHouse;
import edu.fiuba.algo3.modelo.Verificador;

import java.util.*;

public class VerificadorFullHouse extends Verificador {
    public VerificadorFullHouse() {
        super();
        this.proximoVerificador = new VerificadorFlush();
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        ordenarPorNumero(cartas);
        Map<List<CartaDePoker>, Integer> gruposDeCoincidenciasNumero = contarPorNumero(cartas);

        if (esDeTipo(cartas)){

            return new FullHouse(this.listaPuntuables);
        }
        return pasarAlSiguiente(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        boolean seEncuentraTrio = false;
        boolean seEncuentraPar = false;
        Map<List<CartaDePoker>, Integer> gruposDeCoincidenciasNumero = contarPorNumero(cartas);
        for (Map.Entry<List<CartaDePoker>, Integer> entry : gruposDeCoincidenciasNumero.entrySet()){
            if (entry.getValue() == 3){
                agregarPuntuables(entry.getKey());
                seEncuentraTrio = true;
            } else if (entry.getValue() == 2) {
                agregarPuntuables(entry.getKey());
                seEncuentraPar = true;
            }
            if (seEncuentraTrio && seEncuentraPar){
                return true;
            }
        }
        return false;
    }


}
