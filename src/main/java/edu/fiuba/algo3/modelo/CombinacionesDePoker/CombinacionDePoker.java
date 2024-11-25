package edu.fiuba.algo3.modelo.CombinacionesDePoker;
import edu.fiuba.algo3.modelo.Mejoras.*;

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
    public void siContieneAplicarMejora(String contexto, String elemento, Mejora mejora){
            if (elemento.equals(this.nombre)){
                this.efecto.recibirMejora(mejora);
            }
    }

    public void aplicarPuntajeAPuntajeJugada(PuntajeJugada puntajeJugada) {
        this.efecto.aplicarAPuntaje(puntajeJugada);
    }

    public String devolverNombreCombinacion(){
        return this.nombre;
    }


}


