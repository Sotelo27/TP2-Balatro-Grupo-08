package edu.fiuba.algo3.modelo.CondicionesDeMejora;
import edu.fiuba.algo3.modelo.ICondicionMejora;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.*;

public class RestriccionACombinacion implements ICondicionMejora {


    private final String contexto = "Jugada";
    private  String elemento;

    public RestriccionACombinacion(String elemento) {
        this.elemento = elemento;
    }

    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora) {
        mejorable.siContieneAplicarMejora(this.contexto, this.elemento, mejora);
    }

    @Override
    public void setElemento(IMejorable mejorable){ }

}
