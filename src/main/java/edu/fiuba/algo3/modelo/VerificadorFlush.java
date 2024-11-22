package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerificadorFlush extends Verificador {

    public VerificadorFlush(){
        this.proximoVerificador = new VerificadorStraight() {
        };

    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new Flush(cartas);
        }
        else{
            return proximoVerificador.verificar(cartas);

        }
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        //que cada carta le pregunte a la siguiente que sea de igual palo
        String primerPalo = cartas.get(0).devolverPalo();
        return cartas.stream().allMatch(card -> card.devolverPalo().equals(primerPalo));
    }
}
