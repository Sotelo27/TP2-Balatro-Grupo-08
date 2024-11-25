package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.IMejorable;

public interface ICondicionMejora {
    public boolean validarCondicion(IMejorable mejorable);
    public void aplicarMejora(IMejorable mejorable, Mejora mejora);
}
