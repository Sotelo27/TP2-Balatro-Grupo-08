package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class SumaFichas implements IMejora{

	public SumaFichas(){
	}

	@Override
	public void seAplicaApuntaje(PuntajeJugada puntaje, float puntos, float multiplicador){
		puntaje.sumarPuntos(puntos);
	}
}

