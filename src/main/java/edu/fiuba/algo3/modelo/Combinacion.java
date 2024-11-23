package edu.fiuba.algo3.modelo;
import java.util.List;

public class Combinacion extends CategoriaComodin {
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
}


