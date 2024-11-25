SumaPuntos
package edu.fiuba.algo3.modelo.Mejoras;

public class SumaPuntos{
	private final int multiplicador;

	public SumaPuntos(int puntos){
		this.puntos = puntos;
	}

	public void aplicarAPuntaje(PuntajeJugada puntaje){
		puntaje.sumarPuntos(this.puntos);
	}
}


