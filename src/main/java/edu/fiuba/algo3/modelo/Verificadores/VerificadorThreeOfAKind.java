package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.ThreeOfAKind;

import java.util.List;
import java.util.Map;

public class VerificadorThreeOfAKind extends Verificador {
    public VerificadorThreeOfAKind() {
        super();
        this.proximoVerificador = new VerificadorTwoPair();
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new ThreeOfAKind(listaPuntuables);
        }
        return pasarAlSiguiente(cartas);
    }


    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        boolean cumpleLaCondicion = false;
        Map<List<CartaDePoker>, Integer> gruposDeCoincidenciasNumero = contarPorNumero(cartas);
        for (Map.Entry<List<CartaDePoker>, Integer> entry : gruposDeCoincidenciasNumero.entrySet()){
            if (entry.getValue() == 3){
                agregarPuntuables(cartas);
                cumpleLaCondicion = true;
            }
            else{
                this.listaPuntuables.addAll(entry.getKey());
            }
        }
        return cumpleLaCondicion;
    }


}
