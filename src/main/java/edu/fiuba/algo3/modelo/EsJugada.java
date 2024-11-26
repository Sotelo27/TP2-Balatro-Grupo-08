package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mejoras.IMejorable;

public class EsJugada implements ICondicionMejora{
    private final String contexto = "Descarte";
    public EsJugada() {}
    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora){
        mejorable.siContieneAplicarMejora(this.contexto,"", mejora);
    };
}
