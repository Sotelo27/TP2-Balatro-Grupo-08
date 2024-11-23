package edu.fiuba.algo3.modelo;

public interface IAccion {
    public void actualizarAcciones(AccionesDisponibles limites);

    public boolean superaLimites(AccionesDisponibles limites);
	
    public int actualizarJugadasRestantes(int cantidadDeJugadas);

    public int actualizarDescartesRestantes(int cantidadDeDescartes);    
}