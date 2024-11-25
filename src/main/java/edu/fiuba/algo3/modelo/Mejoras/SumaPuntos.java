package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class SumaPuntos{
	private final int puntos;

	public SumaPuntos(int puntos){
		this.puntos = puntos;
	}

	public void aplicarAPuntaje(PuntajeJugada puntaje){
		puntaje.sumarPuntos(this.puntos);
	}
}


