package edu.fiuba.algo3.modelo.Mejoras;

public class CombinacionDeComodines implements IMejorador{
	private final List<Comodin> comodines;

	public CombinacionDeComodines(String nombre, List<Comodin> comodines){
		this.comodines = comodines;
	}

	@Override
	public void mejorar(IMejorable mejorable){
		for (Comodin comodin: this.comodines){
			comodin.mejorar(mejorable)
		}
	}
}