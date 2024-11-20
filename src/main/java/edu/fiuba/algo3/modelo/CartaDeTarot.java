package edu.fiuba.algo3.modelo;

public class CartaDeTarot implements IMejorador {
    String nombre;
    String description;
    Mejora mejora;
    String tipo;


    public CartaDeTarot(String nombre, String description, int puntos, int multiplicador, String tipo){
        this.nombre = nombre;
        this.description = description;

        this.tipo = tipo;
    }

    @Override
    public void mejorar(IMejorable mejorable){
        mejorable.recibirMejora(this.mejora);

    }

}
