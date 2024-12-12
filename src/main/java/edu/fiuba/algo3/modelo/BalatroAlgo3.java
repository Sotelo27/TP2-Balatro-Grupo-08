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
        this.rondaActual = rondas.get(0);
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

    public List<ICarta> getCartasEnMano(){
        return jugador.getCartasEnMano();
    }

    public void realizarJugada(){
        this.jugador.realizarJugada(this.rondaActual);
        // validar victoria de todas las rondas o la derrota en alguna para cambiar de estado
    }

    public void realizarDescarte(){
        this.jugador.realizarDescarte(this.rondaActual);
    }


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
    public boolean estaListoParaJugar() {
        return false;
    }

    @Override
    public boolean noQuedanMasRondas() {
        return false;
    }

    @Override
    public boolean perdioRonda() {
        return rondaActual.estaPerdida();
    }

    private void pasarDeRonda() {
        rondas.remove(rondaActual);
        this.rondaActual = rondas.get(0);
        jugador.vaciarMano();
    }


    @Override
    public void setEstado(EstadoJuego nuevoEstado) {
        this.estado = nuevoEstado;
    };

    @Override
    public void cambiarDeEstado(AbstractState nuevoEstado) throws IOException {
        this.estado.cambiarA(nuevoEstado);
    }

    @Override
    public void update() {
        this.estado.actualizar();
    }

    @Override
    public void iniciarJuego() throws IOException {
        this.estado.render();
    }

    @Override
    public void setJugador(String jugador) {
        this.jugador = new Jugador(jugador, mazo);
    }
}