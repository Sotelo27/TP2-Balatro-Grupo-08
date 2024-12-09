package edu.fiuba.algo3.modelo.CondicionesDeMejora;
import edu.fiuba.algo3.modelo.ICondicionMejora;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.*;

public class EsDescarte implements ICondicionMejora {

    private final String contexto = "Descarte";

    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora) {
        mejorable.siContieneAplicarMejora(this.contexto,"", mejora);
    }
}
