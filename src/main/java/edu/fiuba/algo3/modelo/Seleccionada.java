package edu.fiuba.algo3.modelo;

public class Seleccionada extends EstadoDeCarta{

    public Seleccionada() {
        this.esPuntuable = false;
    }

    @Override
    public void aplicarResultadoAPuntaje(Efecto efecto,PuntajeJugada puntajeJugada){
        efecto.calcularPuntajeCarta(puntajeJugada);
    }


}
