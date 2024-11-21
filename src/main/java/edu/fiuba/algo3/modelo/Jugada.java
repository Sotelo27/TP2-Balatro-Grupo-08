package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;



public class Jugada {

    private final List <CartaDePoker> cartas;



    public Jugada( List<CartaDePoker> seleccion){
        this.cartas = seleccion;



    };




    public  PuntajeJugada jugarJugada(){
        CombinacionDePoker combinacion = new CombinacionDePoker(this.cartas);
        PuntajeJugada puntaje = new PuntajeJugada();
        combinacion.aplicarPuntajeAPuntajeJugada(puntaje);


        for(CartaDePoker carta: this.cartas) {
            carta.sumarAPuntajeJugada(puntaje);
        }
        return puntaje;
    }

}
