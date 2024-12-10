package edu.fiuba.algo3.modelo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PuntajeJugada {
    private float puntos;
    private float multiplicador;


    //la idea es que reciba un tipo de jugada en base a las cartas  que tenga
    public PuntajeJugada(float puntos, float multiplicador) {
        this.puntos = puntos;
        this.multiplicador = multiplicador;
    }

    public void agregarPuntosYMultiplicador(float puntos, float multiplicador) {
        this.puntos += puntos;
        this.multiplicador += multiplicador;
    }

    public void multiplicarMultiplicador(float multiplicador) {
        this.multiplicador *= multiplicador;
    }
    public void reemplazaPuntos(float puntos, float multiplicador) {
        this.puntos = puntos;
        this.multiplicador = multiplicador;
    }
    public void reemplazaMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }
    /*
    public void calcularPuntosCombinacion(CombinacionDePoker combinacionDePoker){

    }
    */
    private float getPuntos() {
        return this.puntos * this.multiplicador;
    }



    public void multiplicarPuntos(float cantidad){
        this.puntos *= cantidad;
    }

    public void sumarPuntos(float puntos){
        this.puntos += puntos;
    }

    public void sumarAMultiplicador(float cantidad){
        this.multiplicador += cantidad;
    }

   public void aplicarPuntajeAPuntajeJugada(PuntajeJugada puntajeJugada) {
        this.puntos = puntajeJugada.getPuntos();
   }

    public boolean esMenorQue(PuntajeJugada otroPuntaje){
        return (this.puntos*this.multiplicador) < (otroPuntaje.getPuntos());
    }

    public boolean esMayorQue(PuntajeJugada otroPuntaje){
        return (this.puntos*this.multiplicador) > (otroPuntaje.getPuntos());
    }

    public boolean esIgualQue(PuntajeJugada otroPuntaje){
        return (this.puntos*this.multiplicador) == (otroPuntaje.getPuntos());
    }

    public void sumarPuntaje(PuntajeJugada puntajeJugada) {
        this.puntos += puntajeJugada.getPuntos();
    }


    public int asInt()  {
        float valor = this.puntos*this.multiplicador ;
        return (int) valor;
    }

    @Override
    public String toString() {
        return String.valueOf(this.puntos*this.multiplicador);
    }

    public StringProperty enObserbable() {
        return new SimpleStringProperty(this.toString());
    }
}
