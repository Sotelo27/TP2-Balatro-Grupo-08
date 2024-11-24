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


    @Override
    public void recibirMejora(Mejora mejorador) {
        this.efecto.recibirMejora(mejorador);
    }

    public void seleccionarCartaEn(Mano mano){



    }
    public void deseleccionarCarta(Mano mano){



    }

    public String devolverPalo(){
        return suit;
    }

    public String devolverRank(){
        return rank;
    }


    public void aplicarResultadoAPuntaje(PuntajeJugada puntajeJugada){

        estadoDeCarta.aplicarResultadoAPuntaje(efecto, puntajeJugada);
    }

    public String getNombre() {
        return nombre;
    }

    public String getPalo() {
        return palo;
    }

    public String getNumero() {
        return numero;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setNumero(String numero) {this.numero = numero;}

    public void setPuntos(int puntos) {this.puntos = puntos;}

    public void setMultiplicador(int multiplicador) {this.multiplicador = multiplicador;}
}



