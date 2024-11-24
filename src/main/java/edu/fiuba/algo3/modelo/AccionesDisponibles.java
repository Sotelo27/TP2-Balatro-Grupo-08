package edu.fiuba.algo3.modelo;
class AccionesDisponibles{
	private int manosDisponibles;
	private int descartesDisponibles;

	public AccionesDisponibles(int manos, int descartes){
		this.manosDisponibles = manos;
		this.descartesDisponibles = descartes;
	}

	public boolean superaLimiteDeDescartes(int descartes){
		return this.descartesDisponibles > descartes;
	}

	public boolean quedanManosDisponibles(int manos){
		return this.manosDisponibles > 0;
	}

	public void reducirDescartesEn(int descartes){
		this.descartesDisponibles -= descartes;
	}

	public void reducirManosDisponibles(){
		this.manosDisponibles -= 1;
	}
	
}