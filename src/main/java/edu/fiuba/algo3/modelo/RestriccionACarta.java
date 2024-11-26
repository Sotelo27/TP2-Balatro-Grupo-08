package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.*;


public class RestriccionACarta implements ICondicionMejora{

    private final String contexto = "carta";
    private final String elemento;

    public RestriccionACarta(String nombreDeCarta) {
        this.elemento = nombreDeCarta;

    }

    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora){
        mejorable.siContieneAplicarMejora(this.contexto,"",mejora);
    };
}
