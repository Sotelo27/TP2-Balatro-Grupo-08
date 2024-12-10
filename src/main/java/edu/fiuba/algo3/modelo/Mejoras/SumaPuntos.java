package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class SumaPuntos implements IMejora{

	public SumaPuntos(){
	}

	@Override
	public void seAplicaApuntaje(PuntajeJugada puntaje, float puntos, float multiplicador){
		puntaje.sumarPuntos(puntos);
	}
}


