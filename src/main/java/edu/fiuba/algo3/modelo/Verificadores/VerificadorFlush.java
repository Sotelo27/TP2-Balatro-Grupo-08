package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.Flush;
import edu.fiuba.algo3.modelo.Verificador;

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
