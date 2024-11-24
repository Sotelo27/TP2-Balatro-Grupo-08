package edu.fiuba.algo3.modelo;

public interface IAccion {
    public void actualizarAcciones(AccionesDisponibles limites);

    public boolean superaLimites(AccionesDisponibles limites);

}