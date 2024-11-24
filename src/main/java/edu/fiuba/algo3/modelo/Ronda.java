package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ronda{
    private LimiteRonda limites;
    private Tienda tienda;
    private List<IAccion> accionesRalizadas;

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

    @JsonProperty("nro")
    private int numero;
    private AccionesJugada limites;
    private int puntajeASuperar;
    private Tienda tienda;

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
