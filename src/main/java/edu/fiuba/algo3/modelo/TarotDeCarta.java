package edu.fiuba.algo3.modelo;

public class TarotDeCarta implements Mejorador{
    String nombre;
    String description;
    int puntos;
    int multiplicador;
    String tipo;


    public TarotDeCarta(String nombre, String description, int puntos, int multiplicador, String tipo){
        this.nombre = nombre;
        this.description = description;
        this.puntos = puntos;
        this.multiplicador = multiplicador;
        this.tipo = tipo;
    }

    @Override
    public void mejorarCarta(Card card){
        card.sumadorMultiplicador(this.multiplicador);
        card.sumadorPuntos(this.puntos);

    }

}
