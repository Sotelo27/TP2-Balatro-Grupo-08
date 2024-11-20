package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.List;

public class Jugada {

    private List <Carta> cartas;


    public Jugada(){
        this.cartas = new ArrayList();
        this.puntaje = new Puntaje();
    };




    public PuntajeJugada jugarJugada(){
        PuntajeJugada puntaje = new PuntajeJugada();
        for(Carta carta: this.cartas){
            carta.aplicarResultadoAPuntaje(puntaje);
        }
    }



}
