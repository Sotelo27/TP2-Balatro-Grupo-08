package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.*;

public class EsDescarte implements ICondicionMejora{

    private final String contexto = "Descarte";

    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora){
        mejorable.siContieneAplicarMejora(this.contexto,"", mejora);
    };

}
