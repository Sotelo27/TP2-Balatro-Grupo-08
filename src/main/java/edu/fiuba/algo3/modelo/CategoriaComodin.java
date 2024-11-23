package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class CategoriaComodin {
    private String descripcion;
    private List<Comodin> comodines;

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Comodin> getComodines() {
        return comodines;
    }
    public void setComodines(List<Comodin> comodines) {
        this.comodines = comodines;
    }
}
