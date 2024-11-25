package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class MultiplicaPuntos{
	private final int multiplicador;

	public MultiplicaPuntos(int multiplicador){
		this.multiplicador = multiplicador;
	}

	public void aplicarAPuntaje(PuntajeJugada puntaje){
		puntaje.multiplicarPuntos(this.multiplicador);
	}
}

