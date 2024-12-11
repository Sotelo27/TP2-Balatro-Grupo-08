package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Estados.EstadoJuego;

import java.io.IOException;

public interface IModelo {
    public void iniciarJuego();

    public void setJugador(String jugador);

    void setEstado(EstadoJuego estado) throws IOException;
}
