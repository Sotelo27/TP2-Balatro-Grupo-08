package edu.fiuba.algo3.modelo;

import java.util.*;

public abstract class CombinacionDePoker implements IMejorable {

    String nombre;
    int puntos;
    int multiplicador;
    Efecto efecto;
    List <CartaDePoker> cartas;

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


}
