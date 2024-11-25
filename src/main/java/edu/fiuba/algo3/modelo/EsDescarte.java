package edu.fiuba.algo3.modelo;

public class EsDescarte implements ICondicionMejora{

    private final String contexto = "Descarte";


    @Override
    public boolean validarCondicion(IMejorable mejorable){
        return mejorable.contiene(this.contexto, "");


    }
}
