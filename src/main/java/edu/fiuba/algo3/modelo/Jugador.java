package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Ficha fichas;
    private Mano mano
    private List<Comodin> comodinesActivos;
    private List<Tarot> tarotsActivos;

    public Jugador(String nombre, Mazo mazo){
        this.nombre = nombre;
        this.mazo = mazo;
        this.mano = new Mano(mazo);
    }
    public void seleccionarCarta(Carta cartasSeleccionada){
        this.mazo.seleccionarCarta(cartasSeleccionada);
    }

    public void realizarJugada(Ronda ronda){
        this.mano.realizarJugada(ronda, tarotsActivos, comodinesActivos);
    }
    public void realizarDescarte(Ronda ronda){
        this.mano.realizarDescarte(Ronda ronda);
    }
    public void activarTarot(Tarot tarot){
        this.tarotsActivos.add(tarot);
    }
    public void activarComodin(Comodin comodin){
        this.comodinesActivos.add(comodin);
    }
}
