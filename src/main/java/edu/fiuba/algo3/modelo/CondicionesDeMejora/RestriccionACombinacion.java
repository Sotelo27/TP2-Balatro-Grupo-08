package edu.fiuba.algo3.modelo.CondicionesDeMejora;
import edu.fiuba.algo3.modelo.ICondicionMejora;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.*;

public class RestriccionACombinacion implements ICondicionMejora {


    private final String contexto = "Mano Jugada";
    private  String elemento;

    public RestriccionACombinacion(String elemento) {
        this.elemento = elemento;
    }

    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora, String contexto, String elemento) {

        mejorable.siContieneAplicarMejora(this.contexto, this.elemento, mejora);
    }

}
