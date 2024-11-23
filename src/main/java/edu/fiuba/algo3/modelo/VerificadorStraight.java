package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerificadorStraight extends Verificador {

    public VerificadorStraight() {
        super();
        this.proximoVerificador = new VerificadorThreeOfAKind();
    };

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        ordenarPorNumero(cartas);

        if (esDeTipo(cartas)){
            return new Straight(cartas);
        }
        return pasarAlSiguiente(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        System.out.println(esSecuencia(cartas));
        System.out.println(cartas);
        if (esSecuencia(cartas)){
            return true;
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
