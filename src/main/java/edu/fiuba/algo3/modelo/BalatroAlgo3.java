package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Estados.AbstractState;
import edu.fiuba.algo3.modelo.Estados.EstadoJuego;
import edu.fiuba.algo3.repositorios.*;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.util.List;

public class BalatroAlgo3 implements IGameState, IModelo{
    private EstadoJuego estado;
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
//      this.inventario = new InventarioTienda(creadorDeObjetos);
    }

    public BalatroAlgo3(LectorDeJSON creadorDeObjetos) throws IOException {
        this.mazo = creadorDeObjetos.construirMazo();
        this.rondas = creadorDeObjetos.construirRondas();
    }



    public void iniciarRonda() {
        jugador.recargarMano();
    }

    public void seleccionarCartaDePoker(String nombre){
        this.jugador.seleccionarCarta(nombre);
    }

    public void activarTarot(ICarta tarot, ICarta carta){
        jugador.activarTarot(tarot,carta);
    }

    public void activarTarot(ICarta tarot){
        jugador.activarTarot(tarot);
    }
    public void activarComodin(String nombre,String sobre){
    }

    public float obtenerPuntajeRonda(){
        return this.rondaActual.obtenerPuntaje().asInt();
    }

    @Override
    public void terminar() {
        this.estado.terminar();
    }

    @Override
    public void reiniciar() {
        this.estado.reiniciar();
    }

    @Override
    public void iniciarJuego() {
        pasarDeRonda();
    }

    public List<ICarta> getCartasEnMano(){
        return jugador.getCartasEnMano();
    }

    public void realizarJugada(){
        this.jugador.realizarJugada(this.rondaActual);
        update();
    }

    public void realizarDescarte(){
        this.jugador.realizarDescarte(this.rondaActual);
        update();
    }


    public void seleccionarCartaDeTienda(ICarta carta) {
        jugador.vaciarMano();
        rondaActual.comprarConJugador(carta, jugador);
        update();
    }

    public List<String> getCartasSeleccionadas() {
        return this. jugador.getCartasSeleccionadas();
    }

    public List<ICarta> getCartasDeTienda() {
        return this.rondaActual.getArticulosTienda();
    }

    public List<ICarta> getCartasActivables(){
        return jugador.getActivables();
    }

    public List<ICarta> getComodinesActivos() {
        return jugador.getComodinesActivos();
    }

    public String getPuntajeObjetivo() {
        return rondaActual.getPuntajeObjetivo();
    }

    public String getDescartesRestantes() {
        return rondaActual.getDescartesRestantes();
    }

    public String getManosRestantes() {
        return rondaActual.getManosRestantes();
    }

    public String getNumeroRonda() {
        return rondaActual.getNumero();
    }

    public StringProperty puntajeObjetivoProperty() {
        return rondaActual.obtenerPuntajeObservable();
    }

    @Override
    public boolean rondaSuperada() {
        if (this.rondaActual.estaSuperada()){
            pasarDeRonda();
            return true;
        }
        return false;
    }

    @Override
    public boolean ganoJuego() {
        return ((rondas.isEmpty()) && (rondaActual.estaSuperada()));
    }

     @Override
    public boolean perdioRonda() {
        return rondaActual.estaPerdida();
    }

    private void pasarDeRonda() {
        if (!rondas.isEmpty()){
            this.rondaActual = rondas.get(0);
            rondas.remove(rondaActual);
        }

    }


    @Override
    public void setEstado(EstadoJuego nuevoEstado) {
        this.estado = nuevoEstado;
    };


    @Override
    public void update() {
        this.estado.actualizar(this);
    }


    @Override
    public void setJugador(String jugador) {
        this.jugador = new Jugador(jugador, mazo);
    }
}