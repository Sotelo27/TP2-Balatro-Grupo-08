package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.IMejorable;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;

public interface ICondicionMejora {
    void aplicarMejora(IMejorable mejorable, Mejora mejora);
}
