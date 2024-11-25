package edu.fiuba.algo3.modelo.CombinacionesDePoker;

import edu.fiuba.algo3.modelo.*;

import java.util.*;

public abstract class CombinacionDePoker implements IMejorable {

    protected String nombre;
    protected Efecto efecto;
    protected List <CartaDePoker> cartas;

    public CombinacionDePoker(List <CartaDePoker> cartas) {
        this.cartas = cartas;

    }

    @Override
    public void recibirMejora(Mejora mejora){
        this.efecto.recibirMejora(mejora);

    }

    @Override
    public boolean contiene(String contexto, String elemento){
        if(contexto.equals("mano") || contexto.equals("Mano jugada")){
            return (elemento.equals(this.nombre));

        }
        return false;
    }

    public void aplicarPuntajeAPuntajeJugada(PuntajeJugada puntajeJugada) {
        this.efecto.aplicarEfectoAPuntaje(puntajeJugada);

    }

    public String devolverNombreCombinacion(){
        return this.nombre;
    }


}


