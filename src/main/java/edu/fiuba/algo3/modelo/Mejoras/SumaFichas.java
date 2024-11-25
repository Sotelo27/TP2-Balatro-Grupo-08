package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class SumaFichas{
	private final int cantidad;

	public SumaFichas(int cantidad){
		this.cantidad = cantidad;
	}

	public void aplicarAPuntaje(PuntajeJugada puntaje){
		puntaje.sumarFichas(this.cantidad);
	}
}

