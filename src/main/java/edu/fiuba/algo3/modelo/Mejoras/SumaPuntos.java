package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class SumaPuntos implements IMejora{

	public SumaPuntos(){
	}

	public void seAplicaApuntaje(PuntajeJugada puntaje, int puntos, int multiplicador){
		puntaje.sumarPuntos(puntos);
	}
}


