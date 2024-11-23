package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class TarotPrueba {
    private String nombre;
    private String descripcion;
    EfectoPrueba efecto;
    private String sobre;
    private String ejemplar;

    @Override
    public String toString() {
        return super.toString();
    }

    @JsonCreator
    public TarotPrueba(@JsonProperty("nombre") String nombre,@JsonProperty("descripcion") String descripcion, @JsonProperty("efecto") EfectoPrueba efecto, @JsonProperty("sobre") String sobre, @JsonProperty("ejemplar") String ejemplar) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.efecto = efecto;
        this.sobre = sobre;
        this.ejemplar = ejemplar;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public EfectoPrueba getEfecto() {
        return efecto;
    }
    public void setEfecto(EfectoPrueba efecto) {
        this.efecto = efecto;
    }
    public String getSobre() {
        return sobre;
    }
    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

}