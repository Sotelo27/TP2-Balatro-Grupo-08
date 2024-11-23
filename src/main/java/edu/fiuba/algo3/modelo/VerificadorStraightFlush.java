package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class VerificadorStraightFlush extends Verificador {

    public VerificadorStraightFlush() {
        super();
        this.proximoVerificador = new VerificadorFourOfAKind();

    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            for (CartaDePoker carta : cartas) {
                carta.changeState(new Puntuable());
            }
            return new StraightFlush (cartas);
        }
        return pasarAlSiguiente(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        ordenarPorNumero(cartas);
        System.out.println(cartas);
        if (sonDelMismoTipo(cartas) && esSecuencia(cartas)) {
            return true;
        }
        return false;
    }



    public List <CartaDePoker> agregarPuntuables(List <CartaDePoker> cartasAPuntuar){
        for (CartaDePoker carta : cartasAPuntuar) {
            carta.changeState(new Puntuable());
        }
        return cartasAPuntuar;
    };


}


