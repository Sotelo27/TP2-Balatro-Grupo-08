package edu.fiuba.algo3.modelo;
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

            return new FullHouse(agregarPuntuables(cartas));
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
                seEncuentraTrio = true;
            } else if (entry.getValue() == 2) {
                seEncuentraPar = true;
            }

            if (seEncuentraTrio && seEncuentraPar){
                return true;
            }
        }
        return false;
    }

    @Override
    public List <CartaDePoker> agregarPuntuables(List <CartaDePoker> cartasAPuntuar){
        for (CartaDePoker carta : cartasAPuntuar) {
            carta.changeState(new Puntuable());
        }
        return cartasAPuntuar;
    };


}
