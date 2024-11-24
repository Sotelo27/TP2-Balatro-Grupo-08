package edu.fiuba.algo3.modelo;

public class CartaDeTarot implements IMejorador {
    String nombre;
    String descripcion;
    Mejora mejora;
    String tipo;
    String sobre;
    String ejemplar;


    public CartaDeTarot() {}

    @Override
    public void mejorar(IMejorable mejorable){
        mejorable.recibirMejora(this.mejora);

    }

    //Setters

    public void setNombre(String unNombre) {this.nombre = unNombre;};

    public void setDescripcion(String unaDescripcion) {this.descripcion = unaDescripcion;}

    public void setEfecto(Mejora unaMejora) {this.mejora = unaMejora;}

    public void setSobre(String unSobre) {this.sobre = unSobre;}

    public void setEjemplar(String unEjemplar) {this.ejemplar = unEjemplar;}

}