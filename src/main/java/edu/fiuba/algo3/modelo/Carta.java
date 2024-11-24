package edu.fiuba.algo3.modelo;

public class Carta {
    private String nombre;
    private String palo;
    private String numero;
    private int puntos;
    private int multiplicador;

    public Carta(){}

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public void setNumero(String numero) {this.numero = numero;}

    public void setPuntos(int puntos) {this.puntos = puntos;}

    public void setMultiplicador(int multiplicador) {this.multiplicador = multiplicador;}
}



