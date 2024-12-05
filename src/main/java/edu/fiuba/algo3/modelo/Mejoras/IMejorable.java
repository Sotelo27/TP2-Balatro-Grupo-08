package edu.fiuba.algo3.modelo.Mejoras;

public interface IMejorable {
    void siContieneAplicarMejora(String contexto, String elemento, Mejora mejora);

    void aplicarMejora(Mejora mejora);

    String getNombre();
}
