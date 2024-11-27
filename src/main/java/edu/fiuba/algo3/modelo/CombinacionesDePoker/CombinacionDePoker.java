package edu.fiuba.algo3.modelo.CombinacionesDePoker;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.*;
import java.util.*;

public abstract class CombinacionDePoker implements IMejorable {

    protected Mejora mejora;
    protected List <CartaDePoker> cartas;
    protected String nombre;
    protected PuntajeJugada puntaje;
    protected int puntos;
    protected int multiplicador;

    public CombinacionDePoker(List <CartaDePoker> cartas) {
        this.mejora = new Mejora();
        this.cartas = cartas;
    }



    @Override
    public void siContieneAplicarMejora(String contexto, String elemento, Mejora mejora){
        if (contexto.equals("Mano Jugada")){
            if (elemento.equals(this.nombre)){
                this.mejora = mejora;
            }
        }
    }

    public void sumarAPuntajeJugada(PuntajeJugada puntajeJugada) {
        this.puntaje = new PuntajeJugada(this.puntos, this.multiplicador);
        this.mejora.seAplicaApuntaje(this.puntaje);
        puntajeJugada.sumarPuntaje(this.puntaje);
    }

    public String devolverNombreCombinacion(){
        return this.nombre;
    }

    @Override
    public String getNombre(){
        return this.nombre;
    }
}


