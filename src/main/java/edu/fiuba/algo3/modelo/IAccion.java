package edu.fiuba.algo3.modelo;

public interface IAccion {
    void actualizarAcciones(AccionesDisponibles limites);

    boolean superaLimites(AccionesDisponibles limites);

    PuntajeJugada aplicaPuntajeDeAccion(PuntajeJugada puntaje);

}