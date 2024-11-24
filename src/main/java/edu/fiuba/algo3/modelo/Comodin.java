package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class Comodin implements IMejorador{

    private String nombre;
    private String descripcion;
    private ICondicionMejora condicionDeMejora;
    private Efecto efecto;

    
    @Override
    public void mejorar(Jugada jugada){
        jugada.recibirEfecto(this.efecto);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setActivacion(Object activacion) {
        this.condicionDeMejora = activacion;
    }

    public void setEfecto(EfectoPrueba efecto) {
        this.efecto = efecto;
    }
}
