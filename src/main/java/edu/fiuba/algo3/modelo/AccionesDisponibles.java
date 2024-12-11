package edu.fiuba.algo3.modelo;

public class AccionesDisponibles{
	private int manosDisponibles;
	private int descartesDisponibles;

	public AccionesDisponibles(int manos, int descartes){
		this.manosDisponibles = manos;
		this.descartesDisponibles = descartes;
	}

	public boolean superaLimiteDeDescartes(int descartes){
		return this.descartesDisponibles < descartes;
	}

	public boolean quedanManosDisponibles(){
		return this.manosDisponibles > 0;
	}

	public void reducirDescartesEn(int descartes){
		this.descartesDisponibles -= descartes;
	}

	public void reducirManosDisponibles(){
		this.manosDisponibles--;
	}

    public String getDescartesRestante() {
		return String.valueOf(descartesDisponibles);
    }

	public String getManosRestantes() {
		return String.valueOf(manosDisponibles);
	}

	public void setManos(int manos) {
		manosDisponibles = manos;
	}

	public void setDescartes(int descartes) {
		descartesDisponibles = descartes;
	}
}