package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;



public class Jugada {

    private final List <CartaDePoker> cartas;
    private final CombinacionDePoker combinacion;


    public Jugada( List<CartaDePoker> seleccion){
        this.cartas = seleccion;

        this.combinacion = new CombinacionDePoker(seleccion);

    };




    public  PuntajeJugada jugarJugada(){
        PuntajeJugada puntaje = new PuntajeJugada();
        for(CartaDePoker carta: this.cartas) {
            carta.sumarAPuntajeJugada(puntaje);
        }
        return puntaje;
    }

}
