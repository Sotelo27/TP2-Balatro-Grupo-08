package edu.fiuba.algo3.modelo.Mejoras;
import edu.fiuba.algo3.modelo.PuntajeJugada;

public class MultiplicaPuntos implements IMejora{


	public MultiplicaPuntos(){
	}

	@Override
	public void seAplicaApuntaje(PuntajeJugada puntaje, float puntos, float multiplicador){
		puntaje.multiplicarPuntos(multiplicador);
	}
}

