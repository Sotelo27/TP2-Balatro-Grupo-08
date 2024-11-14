package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.List;

public class Jugada {

    private List <Card> cartas;


    public Jugada(){
        this.cartas = new ArrayList();
        this.puntaje = new Puntaje();
    };


    public void agregarCarta(Card card){
        cartas.add(card);
    }

    public PuntajeJugada jugarJugada(){
        for(int i = 0; i < cartas.size(); i++){
            cartas.get(i).aplicarResultadoDeCarta(puntaje);
        }
    }



}
