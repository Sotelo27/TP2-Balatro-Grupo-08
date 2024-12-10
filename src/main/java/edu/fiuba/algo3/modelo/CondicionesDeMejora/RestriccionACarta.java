package edu.fiuba.algo3.modelo.CondicionesDeMejora;
import edu.fiuba.algo3.modelo.ICondicionMejora;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.*;


public class RestriccionACarta implements ICondicionMejora {

    private final String contexto = "carta";
    private String elemento = "";

    public RestriccionACarta(String nombreDeCarta) {
        this.elemento = nombreDeCarta;

    }
    public RestriccionACarta(){

    }

    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora){
        mejorable.siContieneAplicarMejora(this.contexto,this.elemento,mejora);
    }
}
