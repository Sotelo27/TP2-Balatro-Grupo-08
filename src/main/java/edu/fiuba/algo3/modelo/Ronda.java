package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ronda {
    private AccionesDisponibles limites;
    private List<IAccion> accionesRalizadas;
    @JsonProperty("nro")
    private int numero;
    private int manos;
    private int descartes;
    private int puntajeASuperar;
    private Tienda tienda;
    private int turnos;


    public Ronda(){
        this.limites = new AccionesDisponibles(manos, descartes);
        this.accionesRalizadas = new ArrayList<IAccion>();
    }

    public Ronda(int numero, int manos, int descartes ){
        this.limites = new AccionesDisponibles(manos, descartes);
        this.accionesRalizadas = new ArrayList<IAccion>();
    }

    public PuntajeJugada obtenerPuntaje(){
        PuntajeJugada puntaje = new PuntajeJugada(0,1);
        for(IAccion accion : this.accionesRalizadas){
            puntaje = accion.aplicaPuntajeDeAccion(puntaje);
        }
        return puntaje;
    }

    public boolean agregarAccion(IAccion accion){
        if (accion.superaLimites(this.limites)){
            return false;
        }
        accion.actualizarAcciones(this.limites);
        this.accionesRalizadas.add(accion);
        return true;
    }

    public void setNumero(int numero) { this.numero = numero;}

    public void setManos(int manos) { this.limites.setManos(manos); }

    public void setPuntajeASuperar(int puntajeASuperar) { this.puntajeASuperar = puntajeASuperar; }

    public void setDescartes(int descartes) { this.limites.setDescartes(descartes); }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public List<ICarta> getArticulosTienda() {
        return this.tienda.getItems();
    }

    public void comprarConJugador(ICarta carta, Jugador jugador) {
        tienda.comprar(carta, jugador);
    }

    public String getPuntajeObjetivo() {
        return String.valueOf(puntajeASuperar);
    }

    public String getDescartesRestantes() {
        return limites.getDescartesRestante();
    }

    public String getManosRestantes() {
        return limites.getManosRestantes();
    }

    public String getNumero() {
        return String.valueOf(numero);
    }

    public boolean estaSuperada() {
        return (obtenerPuntaje().asInt() > puntajeASuperar);
    }

    public boolean estaPerdida() {
        return ((this.accionesRalizadas.size() == 5) && obtenerPuntaje().asInt() < puntajeASuperar);
    }
}
