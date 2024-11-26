package edu.fiuba.algo3.modelo;
import 	edu.fiuba.algo3.modelo.Mejoras.*;
import java.util.List;
import java.util.ArrayList;


public class Descarte implements IAccion, IMejorable {
	private final List <CartaDePoker> cartas;
	private Efecto efecto;

	public Descarte(List <CartaDePoker> descartes){
		this.cartas = descartes;
		this.efecto = new Efecto(0,1);
	}
	@Override
	public void siContieneAplicarMejora(String contexto, String elemento, Mejora mejora){
		if(contexto.equals("Descarte")){
			this.efecto.recibirMejora(mejora);
		}
	};

    @Override 
    public void actualizarAcciones(AccionesDisponibles limites){
        limites.reducirDescartesEn(this.cartas.size());
	}
	@Override
	public boolean superaLimites(AccionesDisponibles limites){
		return limites.superaLimiteDeDescartes(this.cartas.size());
	}

	@Override
	public void aplicaPuntajeDeAccion(PuntajeJugada puntaje){
		this.efecto.aplicarAPuntaje(puntaje);

	}

	public void aplicarMejora(Mejora mejora){}


}
