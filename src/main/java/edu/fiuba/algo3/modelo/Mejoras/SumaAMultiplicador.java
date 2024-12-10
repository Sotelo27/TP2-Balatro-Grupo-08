package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class SumaAMultiplicador implements IMejora{

	public SumaAMultiplicador(){
	}


	@Override
	public void seAplicaApuntaje(PuntajeJugada puntaje, float puntos, float multiplicador){
		puntaje.sumarAMultiplicador(multiplicador);
	}
}

