package edu.fiuba.algo3.modelo;

public class Tarot {
    private String nombre;
    private String descripcion;
    private EfectoPrueba efecto; // Supongo que ya tienes esta clase definida
    private String sobre;
    private String ejemplar;

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

    public String getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(String ejemplar) {
        this.ejemplar = ejemplar;
    }

    @Override
    public String toString() {
        return "Tarot{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", efecto=" + efecto +
                ", sobre='" + sobre + '\'' +
                ", ejemplar='" + ejemplar + '\'' +
                '}';
    }
}
