package edu.fiuba.algo3.modelo;

public class Ronda {
    private int numero;
    private int manos;
    private int descartes;
    private int puntajeASuperar;
    private Tienda tienda;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getManos() {
        return manos;
    }

    public void setManos(int manos) {
        this.manos = manos;
    }

    public int getPuntajeASuperar() {
        return puntajeASuperar;
    }

    public void setPuntajeASuperar(int puntajeASuperar) {
        this.puntajeASuperar = puntajeASuperar;
    }

    public int getDescartes() {
        return descartes;
    }

    public void setDescartes(int descartes) {
        this.descartes = descartes;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
