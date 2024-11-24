package edu.fiuba.algo3.modelo;

import java.util.List;

public class Comodin implements IMejorador{
    private String nombre;
    private String descripcion;
    private Object activacion; // parsear a IcondicionMejora
    private Mejora efecto;
    private List<Comodin> comodines;

    @Override
    public void mejorar(IMejorable mejorable){mejorable.recibirMejora(this.efecto);}
    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setActivacion(Object activacion) {
        this.activacion = activacion;
    }


    public void setEfecto(Mejora efecto) {
        this.efecto = efecto;
    }

    public void setComodines(List<Comodin> comodines) {this.comodines = comodines;}
}



