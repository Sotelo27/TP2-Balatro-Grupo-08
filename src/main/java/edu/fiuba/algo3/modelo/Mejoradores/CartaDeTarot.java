package edu.fiuba.algo3.modelo.Mejoradores;
import edu.fiuba.algo3.modelo.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.CartaDePoker;

public class CartaDeTarot implements IMejorador{
    private String nombre;
    private String descripcion;
    private Mejora mejora;
    private String sobre;
    private String ejemplar;


    public CartaDeTarot() {}

    public CartaDeTarot(String nombre, Mejora mejora, String sobre, String ejemplar) {
        this.nombre = nombre;
        this.mejora = mejora;
        this.sobre = sobre;
        this.ejemplar = ejemplar;
    }

    @Override
    public void mejorar(IMejorable mejorable){
        mejorable.siContieneAplicarMejora(this.sobre, this.ejemplar, this.mejora);
    }
    public void activarSobre(CartaDePoker cartaObjetivo){
        this.ejemplar = cartaObjetivo.getNombre();
    }


    //Setters

    public void setNombre(String unNombre) {this.nombre = unNombre;};

    public void setDescripcion(String unaDescripcion) {this.descripcion = unaDescripcion;}

    public void setEfecto(Mejora unaMejora) {this.mejora = unaMejora;}

    public void setSobre(String unSobre) {this.sobre = unSobre;}

    public void setEjemplar(String unEjemplar) {this.ejemplar = unEjemplar;}




}