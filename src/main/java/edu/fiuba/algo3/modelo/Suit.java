package edu.fiuba.algo3.modelo;

public class Suit {
    protected String suitName;

    public Suit(String suitName) {
        this.suitName = suitName;
    }

    public boolean equals(String nombreAComparar) {
        return this.suitName.equals(nombreAComparar);

    }
}
