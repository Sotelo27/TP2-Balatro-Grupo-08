package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.HighCard;

import java.util.List;
import java.util.Map;

public class VerificadorHighCard extends Verificador {

    public VerificadorHighCard() {
        super();
        this.proximoVerificador = null;
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new HighCard(this.listaPuntuables);
        }
        else {
            return null;
        }
    };

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        boolean condicionSeCumple = false;
        Map<List<CartaDePoker>, Integer> gruposDeCoincidenciasNumero = contarPorNumero(cartas);
        for (Map.Entry<List<CartaDePoker>, Integer> entry : gruposDeCoincidenciasNumero.entrySet()){
            if(!condicionSeCumple){
                condicionSeCumple = true;
                agregarPuntuables(entry.getKey());
            }
            else{
                this.listaPuntuables.addAll(entry.getKey());
            }
        }
        return condicionSeCumple;
    }

}
