package edu.fiuba.algo3.modelo;

public class EfectoPrueba {
    private int puntos;
    private int multiplicador;

    // Getters y setters
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public String toString() {
        return "EfectoPrueba{" +
                "puntos=" + puntos +
                ", multiplicador=" + multiplicador +
                '}';
    }
}
