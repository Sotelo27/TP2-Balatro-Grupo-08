package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.*;

public class RestriccionACombinacion implements ICondicionMejora{


    private final String contexto = "Jugada";
    private final String elemento;

    public RestriccionACombinacion(String combinacion) {
        this.elemento = combinacion;

    }



    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora){
        mejorable.siContieneAplicarMejora(this.contexto, this.elemento, mejora);
    };

}
