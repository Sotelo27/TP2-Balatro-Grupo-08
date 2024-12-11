package edu.fiuba.algo3.modelo;

public interface IGameState {
    boolean perdioRonda();

    boolean rondaSuperada();

    boolean estaListoParaJugar();

    boolean noQuedanMasRondas();
}
