package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class CartaDePoker implements IMejorable {
    String nombre;
    String palo;
    String numero;
    private int puntos;
    private int multiplicador;
    Efecto efecto;


    //Setters
    public CartaDePoker() {}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public void setNumero(String numero) {this.numero = numero;}

    public void setPuntos(int puntos) {this.puntos = puntos;}

    public void setMultiplicador(int multiplicador) {this.multiplicador = multiplicador;}

    @Override
    public void recibirMejora(Mejora mejora) {
        efecto.recibirMejora(mejora);
    }

    public void sumarAPuntajeJugada(PuntajeJugada puntajeJugada) {
        efecto.calcularPuntajeCarta(puntajeJugada);

    }

    //esto tambien vuela por violar encapsulamiento.
    public String devolverPalo(){
        return palo;
    }

    // Recomendación: Deberíamos tener un metodo que me compare una carta con otra para saber si son la misma o al menos del mismo tipo.

    // esto tambien deberia volar.
    public String devolverRank(){
        return numero;
    }
}



