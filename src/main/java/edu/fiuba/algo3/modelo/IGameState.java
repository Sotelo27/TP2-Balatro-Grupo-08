package edu.fiuba.algo3.modelo;

public interface IGameState {
    boolean perdioRonda();

    boolean rondaSuperada();

    boolean ganoJuego();

    void cargarContenido();
}
