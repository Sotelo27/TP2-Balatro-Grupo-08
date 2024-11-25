package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class SumaAMultiplicador{
	private final int multiplicador;

	public SumaAMultiplicador(int multiplicador){
		this.multiplicador = multiplicador;
	}

	public void aplicarAPuntaje(PuntajeJugada puntaje){
		puntaje.sumarAMultiplicador(this.multiplicador);
	}
}

