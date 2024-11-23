package edu.fiuba.algo3.modelo;
import java.util.*;

public class VerificadorFourOfAKind extends Verificador{
    public VerificadorFourOfAKind() {
        super();
        this.proximoVerificador = new VerificadorFullHouse();


    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new FourOfAKind(this.listaPuntuables);
        }
        return pasarAlSiguiente(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        boolean cumpleLaCondicion = false;
        Map<List<CartaDePoker>, Integer> gruposDeCoincidenciasNumero = contarPorNumero(cartas);
        for (Map.Entry<List<CartaDePoker>, Integer> entry : gruposDeCoincidenciasNumero.entrySet()){
            if (entry.getValue() == 4){
                agregarPuntuables(entry.getKey());
                cumpleLaCondicion = true;
            }
            else{
                this.listaPuntuables.addAll(entry.getKey());
            }
        }
        return cumpleLaCondicion;
    }


}
