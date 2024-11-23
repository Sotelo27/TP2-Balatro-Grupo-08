package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class VerificadorThreeOfAKind extends Verificador {
    public VerificadorThreeOfAKind() {
        super();
        this.proximoVerificador = new VerificadorTwoPair();

    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        ordenarPorNumero(cartas);
        if (esDeTipo(cartas)){
            return new ThreeOfAKind(cartas);
        }
        return pasarAlSiguiente(cartas);
    }


    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        Map<List<CartaDePoker>, Integer> gruposDeCoincidenciasNumero = contarPorNumero(cartas);
        for (Map.Entry<List<CartaDePoker>, Integer> entry : gruposDeCoincidenciasNumero.entrySet()){
            if (entry.getValue() == 3){
                cartas = agregarPuntuables(entry.getKey());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<CartaDePoker> agregarPuntuables(List<CartaDePoker> cartasAPuntuar) {
        for (CartaDePoker carta : cartasAPuntuar){
            carta.changeState(new Puntuable());
        }
        return cartasAPuntuar;

    }
}
