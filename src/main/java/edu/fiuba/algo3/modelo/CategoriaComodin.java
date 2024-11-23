package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class CategoriaComodin {
    private String descripcion;
    private List<Comodin> comodines;

    // Métodos comunes
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setComodines(List<Comodin> comodines) { this.comodines = comodines; }
    public String getDescripcion() { return descripcion; }
    public List<Comodin> getComodines() { return comodines; }

    // Método abstracto que implementarán las subclases
    public abstract String getNombreCategoria();

    // Método fábrica para crear la instancia adecuada
    public static CategoriaComodin crearDesdeNombre(String nombreCategoria) {
        switch (nombreCategoria.toLowerCase()) {
            case "al puntaje":
                return new AlPuntaje();
            case "bonus por descarte":
                return new BonusPorDescarte();
            case "combinación":
                return new Combinacion();
            case "bonus por mano jugada":
                return new BonusPorManoJugada();
            case "chance de activarse aleatoriamente":
                return new ComodinAleatorio();
            default:
                throw new IllegalArgumentException("Categoría desconocida: " + nombreCategoria);
        }
    }
}


