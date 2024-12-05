package edu.fiuba.algo3.modelo.Mejoradores;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.ICondicionMejora;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.*;

public class CartaDeTarot implements IMejorador{
    private String nombre;
    private String descripcion;
    private Mejora mejora;
    private ICondicionMejora condicion;
    private String sobre;
    private String ejemplar;

/*
    public CartaDeTarot(String nombre, Mejora mejora, ICondicionMejora condicion) {
        this.condicion = condicion;
        this.nombre = nombre;
        this.mejora = mejora;
    } */

    @JsonCreator
    public CartaDeTarot(@JsonProperty("nombre") String nombre, @JsonProperty("descripcion") String descripcion, @JsonProperty("efecto") Mejora mejora, @JsonProperty("sobre") String sobre, @JsonProperty("ejemplar") String ejemplar){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sobre = sobre;
        this.mejora = mejora;
        this.ejemplar = ejemplar;
    }

    public CartaDeTarot(String nombre, Mejora mejora, ICondicionMejora condicion, String sobre, String ejemplar) {
        this.nombre = nombre;
        this.mejora = mejora;
        this.sobre = sobre;
        this.ejemplar = ejemplar;
        this.condicion = condicion;
    }

    @Override
    public void mejorar(IMejorable mejorable){

        condicion.aplicarMejora(mejorable, this.mejora, this.sobre, this.ejemplar);
    }


    //Setters

    public void setNombre(String unNombre) {this.nombre = unNombre;};

    public void setDescripcion(String unaDescripcion) {this.descripcion = unaDescripcion;}

    public void setEfecto(Mejora unaMejora) {this.mejora = unaMejora;}

    public void setSobre(String unSobre) {this.sobre = unSobre;}

    public void setEjemplar(IMejorable unEjemplar) {this.ejemplar = unEjemplar.getNombre();}


    public String getNombre() {
        return this.nombre;
    }
}