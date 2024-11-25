package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.*;

public interface IMejorable {
    // void recibirMejora(Mejora mejora);
    // void contiene(String contexto, String elemento);
    void siContieneAplicarMejora(String contexto, String elemento, Mejora mejora);

}
