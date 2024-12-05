package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.RoyalFlush;

import java.util.List;

public class VerificadorRoyalFlush extends Verificador {

    public VerificadorRoyalFlush() {
        super();
        this.proximoVerificador = new VerificadorStraightFlush ();
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        boolean cumpleLaCondicion = false;
        List <String> secuenciaRoyalFlush = List.of("A","K","Q","J","10");
        int contadorSecuencia = 0;
        for (CartaDePoker carta : cartas) {
            if (!carta.soyDelMismoNumero(secuenciaRoyalFlush.get(contadorSecuencia))){
                return false;
            };
            contadorSecuencia++;
        }
        agregarPuntuables(cartas);
        return sonDelMismoTipo(cartas);
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        ordenarPorNumero(cartas);
        if (esDeTipo(cartas)) {
            return new RoyalFlush(this.listaPuntuables);
        }
        return pasarAlSiguiente(cartas);
    }


}
