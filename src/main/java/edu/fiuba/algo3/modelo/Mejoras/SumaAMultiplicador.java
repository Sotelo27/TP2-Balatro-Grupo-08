package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class SumaAMultiplicador implements IMejora{

	public SumaAMultiplicador(){
	}


	@Override
	public void seAplicaApuntaje(PuntajeJugada puntaje, int puntos, int multiplicador){
		puntaje.sumarAMultiplicador(multiplicador);
	}
}

