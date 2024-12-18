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
        limites.reducirDescartesEn(1);
	}
	@Override
	public boolean superaLimites(AccionesDisponibles limites){
		return limites.superaLimiteDeDescartes(1);
	}

	@Override
	public PuntajeJugada aplicaPuntajeDeAccion(PuntajeJugada puntaje){
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
