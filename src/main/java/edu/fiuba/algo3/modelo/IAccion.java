package edu.fiuba.algo3.modelo;

public interface IAccion {
    void actualizarAcciones(AccionesDisponibles limites);

    boolean superaLimites(AccionesDisponibles limites);

    void aplicaPuntajeDeAccion(PuntajeJugada puntaje);

}