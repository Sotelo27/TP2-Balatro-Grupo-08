package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mejoras.IMejorable;

public class SinRestriccion implements ICondicionMejora{

    private final String contexto = "Jugada";


    public SinRestriccion() {


    }




    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora){
        mejorable.siContieneAplicarMejora(this.contexto, "", mejora);
    };
}
