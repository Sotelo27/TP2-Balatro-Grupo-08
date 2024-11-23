package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerificadorFlush extends Verificador {

    public VerificadorFlush(){
        this.proximoVerificador = new VerificadorStraight ();
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        if (sonDelMismoTipo(cartas)){
            agregarPuntuables(cartas);
            return true;
        }
        return false;
    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new Flush(this.listaPuntuables);
        }
        return pasarAlSiguiente(cartas);
    }




}
