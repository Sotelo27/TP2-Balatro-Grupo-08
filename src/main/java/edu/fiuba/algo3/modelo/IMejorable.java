package edu.fiuba.algo3.modelo;

public interface IMejorable {
    void recibirMejora(Mejora mejora);

    void mejorar(IMejorador mejorador);
}
