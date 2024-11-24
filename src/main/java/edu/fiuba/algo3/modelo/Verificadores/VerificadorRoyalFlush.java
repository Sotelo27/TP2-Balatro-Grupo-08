package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.RoyalFlush;
import edu.fiuba.algo3.modelo.Verificador;

import java.util.List;
import java.util.Map;

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
        return sonDelMismoTipo(cartas);
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)) {
            return new RoyalFlush(this.listaPuntuables);
        }
        return pasarAlSiguiente(cartas);

    }


}
