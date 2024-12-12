package edu.fiuba.algo3.modelo;
import 	edu.fiuba.algo3.modelo.Mejoras.*;

import java.util.ArrayList;
import java.util.List;


public class Descarte implements IAccion, IMejorable {
	private final List <CartaDePoker> cartas;
	private List <Mejora> mejoras;

	public Descarte(List <CartaDePoker> descartes){
		this.cartas = descartes;
		this.mejoras = new ArrayList<Mejora>();
	}
	@Override
	public void siContieneAplicarMejora(String contexto, String elemento, Mejora mejora){
		if(contexto.equals("Descarte")){
			this.mejoras.add(mejora);
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
	public PuntajeJugada aplicaPuntajeDeAccion(PuntajeJugada puntaje){
		//this.efecto.aplicarAPuntaje(puntaje);
		//PuntajeJugada puntajeEnCero = new PuntajeJugada(0,1);
		for(Mejora mejora: this.mejoras) {
			mejora.seAplicaAPuntaje(puntaje);
		}

		return puntaje;
	}

	public void aplicarMejora(Mejora mejora){
		this.mejoras.add(mejora);
	}

	public String getNombre(){
		return "Descarte";
	}
}
