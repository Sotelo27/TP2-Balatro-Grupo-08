package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MazoCombinacion {
    String descripcion;
    @JsonProperty("comodines")
    List<Combinacion> combinaciones;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Combinacion> getCombinaciones() {
        return combinaciones;
    }

    public void setCombinaciones(List<Combinacion> combinaciones) {
        this.combinaciones = combinaciones;
    }
}
