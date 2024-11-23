package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class Ronda{
	private LimiteRonda limites;
	private Tienda tienda;
	private List<IAccion> accionesRalizadas;

	public Ronda(int numero, int manos, int descartes){

	}

	public Puntaje calcularPuntaje(){
		Puntaje puntaje = new Puntaje();
		for(IAccion accion : this.accionesRalizadas){
			accion.sumarAPuntaje(puntaje);
		}
		return puntaje
	}

	public boolean agregarAccion(IAccion accion){
		if (accion.superaLimites(this.Limites)){
			return false
		}
		accion.actualizarAcciones(this.Limites);
		this.accionesRalizadas.add()
		return true
	}
}