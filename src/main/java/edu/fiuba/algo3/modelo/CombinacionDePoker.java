package edu.fiuba.algo3.modelo;

import java.util.*;

public abstract class CombinacionDePoker implements IMejorable {

    protected String nombre;
    protected Efecto efecto;
    protected List <CartaDePoker> cartas;
    protected int multiplicador;
    protected int puntos;

    public CombinacionDePoker(List <CartaDePoker> cartas) {
        this.cartas = cartas;

    }

    @Override
    public void recibirMejora(Mejora mejora){
        this.efecto.recibirMejora(mejora);

    };

    public void aplicarPuntajeAPuntajeJugada(PuntajeJugada puntajeJugada) {
        this.efecto.aplicarEfectoAPuntaje(puntajeJugada);

    }

    public String devolverNombreCombinacion(){
        return this.nombre;
    }


}


