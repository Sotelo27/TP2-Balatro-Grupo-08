package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.modelo.Mejoras.*;
import java.util.List;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Ficha fichas;
    private Mano mano;
    private List<Comodin> comodinesActivos;
    private List<IMejorador> tarotsActivos;
    private Mazo mazo;

    public Jugador(String nombre, Mazo mazo){
        this.nombre = nombre;
        this.mazo = mazo;
        this.mano = new Mano(mazo);
        this.comodinesActivos = new ArrayList<>();
        this.tarotsActivos = new ArrayList<>();
    }
    public void seleccionarCarta(CartaDePoker cartasSeleccionada){
        this.mano.seleccionarCarta(cartasSeleccionada);
    }

    public void realizarJugada(Ronda ronda){
        this.mano.realizarJugada(ronda, this.tarotsActivos, this.comodinesActivos);
    }
    public void realizarDescarte(Ronda ronda){
        this.mano.realizarDescarte( ronda);
    }
    public void activarTarot(CartaDeTarot tarot, CartaDePoker cartaObjetivo){
        //this.tarotsActivos.activarSobre(cartaObjetivo); Hay que buscar la carta correcta
        this.tarotsActivos.add(tarot);
    }
    public void activarComodin(Comodin comodin){
        this.comodinesActivos.add(comodin);
    }
}
