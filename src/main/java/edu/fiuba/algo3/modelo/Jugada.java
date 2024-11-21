package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jugada {

    private final List <CartaDePoker> cartas;


    public Jugada( List <CartaDePoker> seleccion){
        this.cartas = seleccion;
    };




    public  PuntajeJugada jugarJugada(){
        PuntajeJugada puntaje = new PuntajeJugada();
        for(CartaDePoker carta: this.cartas) {
            puntaje.agregarPuntosYMultiplicador(carta.devolverValor(),1);
        }
        return puntaje;
    }

}
