package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Estados.AbstractState;
import edu.fiuba.algo3.modelo.Estados.EstadoJuego;

import java.io.IOException;
import java.util.List;

public interface IModelo {

    //public void iniciarJuego() throws IOException;

    public void setJugador(String jugador);

    void setEstado(EstadoJuego estado) throws IOException;

    void update();

    List<ICarta> getCartasDeTienda();

    void seleccionarCartaDeTienda(ICarta carta);

    void seleccionarCartaDePoker(String nombre);

    void activarTarot(ICarta tarot);

    void realizarDescarte();

    void realizarJugada();

    
    void iniciarRonda();

    List<ICarta> getCartasEnMano();

    List<ICarta> getCartasActivables();

    List<ICarta> getComodinesActivos();

    String getPuntajeObjetivo();

    String getDescartesRestantes();

    String getManosRestantes();

    String getNumeroRonda();

    float obtenerPuntajeRonda();

    void terminar();

    void reiniciar();

    void iniciarJuego();
}
