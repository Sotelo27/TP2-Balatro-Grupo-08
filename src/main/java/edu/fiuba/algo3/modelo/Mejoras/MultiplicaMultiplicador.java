package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class MultiplicaMultiplicador{
	private final int multiplicador;

	public MultiplicaMultiplicador(int multiplicador){
		this.multiplicador = multiplicador;
	}

	public void aplicarAPuntaje(PuntajeJugada puntaje){
		puntaje.multiplicarMultiplicador(this.multiplicador);
	}
}

