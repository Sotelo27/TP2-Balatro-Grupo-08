package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.IMejorable;

public interface ICondicionMejora {
    void aplicarMejora(IMejorable mejorable, Mejora mejora, String contexto, String elemento);
}
