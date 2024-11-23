package edu.fiuba.algo3.modelo;
import java.util.*;

public class VerificadorOnePair extends Verificador {
    public VerificadorOnePair() {
        super();
        this.proximoVerificador = new VerificadorHighCard();


    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new OnePair(listaPuntuables);
        }
        return pasarAlSiguiente(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        boolean cumpleLaCondicion = false;
        Map<List<CartaDePoker>, Integer> gruposDeCoincidenciasNumero = contarPorNumero(cartas);
        for (Map.Entry<List<CartaDePoker>, Integer> entry : gruposDeCoincidenciasNumero.entrySet()){
            if (entry.getValue() == 2 ){
                agregarPuntuables(entry.getKey());
                cumpleLaCondicion = true;
            }
            else{
                listaPuntuables.addAll(entry.getKey());
            }
        }
        return cumpleLaCondicion;
    }


}
