package edu.fiuba.algo3.modelo.Mejoradores;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.*;

public class CartaDeTarot implements IMejorador{
    String nombre;
    String descripcion;
    Mejora mejora;
    String sobre;
    String ejemplar;


    public CartaDeTarot() {}

    @Override
    public void mejorar(IMejorable mejorable){
        if(mejorable.contiene(this.sobre, this.ejemplar)){
            mejorable.recibirMejora(this.mejora);
        }

    }



    //Setters

    public void setNombre(String unNombre) {this.nombre = unNombre;};

    public void setDescripcion(String unaDescripcion) {this.descripcion = unaDescripcion;}

    public void setEfecto(Mejora unaMejora) {this.mejora = unaMejora;}

    public void setSobre(String unSobre) {this.sobre = unSobre;}

    public void setEjemplar(String unEjemplar) {this.ejemplar = unEjemplar;}




}