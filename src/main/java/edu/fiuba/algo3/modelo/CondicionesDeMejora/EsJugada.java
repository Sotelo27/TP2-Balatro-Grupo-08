package edu.fiuba.algo3.modelo.CondicionesDeMejora;

import edu.fiuba.algo3.modelo.ICondicionMejora;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.IMejorable;

public class EsJugada implements ICondicionMejora {
    private final String contexto = "Jugada";

    public EsJugada() {}

    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora, String contexto, String elemento) {
        if(mejorable.getNombre() == this.contexto){
            mejorable.aplicarMejora(mejora);
        }

    }
}
