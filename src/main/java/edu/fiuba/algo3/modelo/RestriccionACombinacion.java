package edu.fiuba.algo3.modelo;

public class RestriccionACombinacion implements ICondicionMejora{


    private final String contexto = "Mano Jugada";
    private final String elemento;

    public RestriccionACombinacion(String combinacion) {
        this.elemento = combinacion;

    }


    @Override
    public boolean validarCondicion(IMejorable mejorable){
        return mejorable.contiene(this.contexto, this.elemento);

    }



}
