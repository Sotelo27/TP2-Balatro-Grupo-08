package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class ReemplazaPuntos implements IMejora{


    public ReemplazaPuntos(){

    }

    @Override
    public void seAplicaApuntaje(PuntajeJugada puntaje, float puntos, float multiplicador){
        puntaje.reemplazaPuntos(puntos,multiplicador);
    }
}
