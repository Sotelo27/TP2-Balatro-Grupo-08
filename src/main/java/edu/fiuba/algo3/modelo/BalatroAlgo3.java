package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Estados.EstadoJuego;
import edu.fiuba.algo3.repositorios.*;

import java.io.IOException;
import java.util.List;

public class BalatroAlgo3{
    private Jugador jugador;
    private List<Ronda> rondas;
    private Ronda rondaActual;
    private Mazo mazo;
    private InventarioTienda inventario;

    public BalatroAlgo3(String nombreDelJugador, LectorDeJSON creadorDeObjetos) throws IOException {
        this.mazo = creadorDeObjetos.construirMazo();
        this.jugador = new Jugador(nombreDelJugador, mazo);
        this.rondas = creadorDeObjetos.construirRondas();
        this.rondaActual = rondas.get(0);
        this.inventario = new InventarioTienda(creadorDeObjetos);
    }

    public void iniciarJuego(){
    }

    public void seleccionarCartaDePoker(String nombre){
        this.jugador.seleccionarCarta(nombre);
    }

    public void activarTarot(String nombre){
    }

    public void activarComodin(String nombre){
    }

    public int obtenerPuntajeRonda(){
        return this.rondaActual.obtenerPuntaje().asInt();
    }

    public List<String> getCartasEnMano(){
        return jugador.getCartasEnMano();
    }

    public void realizarJugada(){
        this.jugador.realizarJugada(this.rondaActual);
        // validar victoria de todas las rondas o la derrota en alguna para cambiar de estado
    }

    public void realizarDescarte(){
        // this.jugador.realizarDescarte(this.ronda)
    }

    public void setEstado(EstadoJuego estado){};

    public List<String> getCartasSeleccionadas() {
        return this. jugador.getCartasSeleccionadas();
    }
    public List<ICarta> getCartasDeTienda() {
        return this.rondaActual.getArticulosTienda();
    }

    public void seleccionarCartaDeTienda(ICarta carta) {
        rondaActual.comprarConJugador(carta, jugador);
    }

    public List<ICarta> getCartasActivables(){
        return jugador.getActivables();
    }

    public List<ICarta> getComodinesActivos() {
        return jugador.getComodinesActivos();
    }
}