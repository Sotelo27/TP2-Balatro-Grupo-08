package edu.fiuba.algo3.modelo.CondicionesDeMejora;

import edu.fiuba.algo3.modelo.ICondicionMejora;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.IMejorable;

public class SinRestriccion implements ICondicionMejora {


    public SinRestriccion() {
    }

    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora) {
        mejorable.aplicarMejora(mejora);
    }
}
