package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.*;

import java.util.List;

public class PuntajeJugada {
    private int puntos;
    private int multiplicador;
    private int fichas;

    //la idea es que reciba un tipo de jugada en base a las cartas  que tenga
    public PuntajeJugada(int puntos, int multiplicador) {
        this.puntos = puntos;
        this.multiplicador = multiplicador;
        this.fichas = 0;
    }

    public void agregarPuntosYMultiplicador(int puntos, int multiplicador) {
        this.puntos += puntos;
        this.multiplicador += multiplicador;
    }

    public void multiplicarMultiplicador(int multiplicador) {
        this.multiplicador *= multiplicador;
    }
    /*
    public void calcularPuntosCombinacion(CombinacionDePoker combinacionDePoker){

    }
    */
    private int getPuntos() {
        return this.puntos * this.multiplicador;
    }

    public void sumarFichas(int cantidad){
        this.fichas += cantidad;
    }

    public void multiplicarPuntos(int cantidad){
        this.puntos *= cantidad;
    }

    public void sumarPuntos(int puntos){
        this.puntos += puntos;
    }

    public void sumarAMultiplicador(int cantidad){
        this.multiplicador += cantidad;
    }



   // public void aplicarPuntajeAPuntajeJugada(PuntajeJugada puntajeJugada) {}

    public boolean esMenorQue(PuntajeJugada otroPuntaje){
        System.out.println("Puntaje 1");
        System.out.println(this.puntos*this.multiplicador);

        System.out.println("puntaje 2:");
        System.out.println(otroPuntaje.getPuntos());
        return (this.puntos*this.multiplicador) < (otroPuntaje.getPuntos()); // no creo que funcione
    }

    public boolean esMayorQue(PuntajeJugada otroPuntaje){
        return (this.puntos*this.multiplicador) > (otroPuntaje.getPuntos()); // no creo que funcione
    }

    public boolean esIgualQue(PuntajeJugada otroPuntaje){
        return (this.puntos*this.multiplicador) == (otroPuntaje.getPuntos()); // no creo que funcione
    }


}
