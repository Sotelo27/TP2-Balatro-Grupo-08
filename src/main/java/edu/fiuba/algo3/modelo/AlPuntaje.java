package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class AlPuntaje {
    String descripcion;
    List<Comodin> comodines;

    AlPuntaje() {
        comodines = new ArrayList<Comodin>();
    }

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
