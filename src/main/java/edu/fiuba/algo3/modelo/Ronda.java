package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ronda{
    private AccionesDisponibles limites;
    private Tienda tienda;
    private List<IAccion> accionesRalizadas;
    @JsonProperty("nro")
    private int numero;
    private int puntajeASuperar;

    public Ronda(int numero, int manos, int descartes){

    }

    public Puntaje calcularPuntaje(){
        Puntaje puntaje = new Puntaje();
        for(IAccion accion : this.accionesRalizadas){
            accion.sumarAPuntaje(puntaje);
        }
        return puntaje;
    }

    public boolean agregarAccion(IAccion accion){
        if (accion.superaLimites(this.Limites)){
            return false;
        }
        accion.actualizarAcciones(this.Limites);
        this.accionesRalizadas.add();
        return true;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setManos(int manos) {
        this.manos = manos;
    }

    public void setPuntajeASuperar(int puntajeASuperar) {
        this.puntajeASuperar = puntajeASuperar;
    }

    public void setDescartes(int descartes) {
        this.descartes = descartes;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
