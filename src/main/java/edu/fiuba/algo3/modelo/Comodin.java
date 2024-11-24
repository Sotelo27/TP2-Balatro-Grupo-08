package edu.fiuba.algo3.modelo;

public class Comodin{

    String nombre;
    String descripcion;
    ICondicionMejora condicionDeMejora;
    Efecto efecto;

    public Comodin(String nombre, String descripcion, Efecto efecto, ICondicionMejora condicionDeMejora ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.efecto = efecto;
        this.condicionDeMejora = condicionDeMejora;

    }


    public void aplicarComodinAJugada(Jugada jugada){
        jugada.recibirEfecto(this.efecto);


    }



}
