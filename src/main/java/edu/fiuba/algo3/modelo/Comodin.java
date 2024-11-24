package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class Comodin implements IMejorador{
    private String nombre;
    private String descripcion;
    private Object activacion; // Puede ser String o Map<String, Object>
    private EfectoPrueba efecto;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Object getActivacion() {
        return activacion;
    }

    public void setActivacion(Object activacion) {
        this.activacion = activacion;
    }

    public EfectoPrueba getEfecto() {
        return efecto;
    }

    public void setEfecto(EfectoPrueba efecto) {
        this.efecto = efecto;
    }


}
