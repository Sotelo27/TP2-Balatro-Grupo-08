package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class SumaPuntaje implements IMejora{

	public SumaPuntaje(){
	}

	@Override
	public void seAplicaApuntaje(PuntajeJugada puntaje, int puntos, int multiplicador){
		puntaje.sumarPuntos(puntos * multiplicador);
	}
}


