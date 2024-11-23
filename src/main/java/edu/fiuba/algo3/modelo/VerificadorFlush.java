package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerificadorFlush extends Verificador {

    public VerificadorFlush(){
        this.proximoVerificador = new VerificadorStraight ();
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        if (sonDelMismoTipo(cartas)){
            return true;
        }
        return false;
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new Flush(agregarPuntuables(cartas));
        }
        return pasarAlSiguiente(cartas);
    }


    @Override
    public List <CartaDePoker> agregarPuntuables(List <CartaDePoker> cartasAPuntuar){
        for (CartaDePoker carta : cartasAPuntuar) {
            carta.changeState(new Puntuable());
        }
        return cartasAPuntuar;
    };
}
