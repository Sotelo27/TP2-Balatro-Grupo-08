package edu.fiuba.algo3.modelo;
import java.util.List;

public class Combinacion extends CategoriaComodin {
    String nombre;
    private List<Comodin> comodinesAnidados;

    @Override
    public String getNombreCategoria() {
        return "combinación";
    }

    public void setComodinesAnidados(List<Comodin> comodinesAnidados) {
        this.comodinesAnidados = comodinesAnidados;
    }

    public List<Comodin> getComodinesAnidados() {
        return comodinesAnidados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}


