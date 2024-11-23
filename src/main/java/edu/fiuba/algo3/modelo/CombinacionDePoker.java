package edu.fiuba.algo3.modelo;

import java.util.*;

public abstract class CombinacionDePoker implements IMejorable {

    protected String nombre;
    protected int puntos;
    protected int multiplicador;
    protected Efecto efecto;
    protected List <CartaDePoker> cartas;

    public CombinacionDePoker(List <CartaDePoker> cartas) {
        this.cartas = cartas;

    }

    @Override
    public void recibirMejora(Mejora mejora){
        this.efecto.recibirMejora(mejora);

    };

    public void aplicarPuntajeAPuntajeJugada(PuntajeJugada puntajeJugada) {
        puntajeJugada.agregarPuntosYMultiplicador(this.puntos, this.multiplicador);
    }

    public int devolverPuntaje(){
        return this.puntos * this.multiplicador;
    }


    public String devolverNombreCombinacion(){
        return this.nombre;
    }


}


