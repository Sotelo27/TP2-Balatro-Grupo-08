package edu.fiuba.algo3.modelo;
import java.util.List;

import java.util.ArrayList;


public class Card {
    private String rank;
    private Suit suit;
    private int puntos;
    private int multiplicador;

    public Card(String rank, Suit suit, int puntos, int multiplicador) {
        this.rank = rank;
        this.suit = suit;
        this.puntos = puntos;
        this.multiplicador = multiplicador;

    }

    public void aplicarPuntajeDeCarta(PuntajeJugada puntaje) {
        puntaje.aplicarPuntajeDeCarta(this.puntos, this.multiplicador);
    }


    public void sumadorMultiplicador(int multiplicador) {
        this.multiplicador += multiplicador;
    }
    public void sumadorPuntos(int puntos) {
        this.puntos += puntos;
    }



}
