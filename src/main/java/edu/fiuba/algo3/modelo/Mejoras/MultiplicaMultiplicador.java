package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class MultiplicaMultiplicador implements IMejora{


	public MultiplicaMultiplicador(){

	}

	@Override
	public void seAplicaApuntaje(PuntajeJugada puntaje, float puntos, float multiplicador){
		puntaje.multiplicarMultiplicador(multiplicador);
	}
}

