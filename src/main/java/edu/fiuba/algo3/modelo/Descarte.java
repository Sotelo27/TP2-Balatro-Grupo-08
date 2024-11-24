package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;


public class Descarte implements IAccion,IMejorable {
	private final List <CartaDePoker> cartas;
	private Efecto efecto;

	public Descarte(List <CartaDePoker> descartes){
		this.cartas = descartes;
		this.efecto = new Efecto(0,1);
	}

    @Override 
    public void actualizarAcciones(AccionesDisponibles limites){
        limites.reducirDescartesEn(this.cartas.size());
	}
	@Override
	public boolean superaLimites(AccionesDisponibles limites){
		return limites.superaLimiteDeDescartes(this.cartas.size());
	}

    public void recibirMejora(Mejora mejora){ }
}
