package edu.fiuba.algo3.modelo.Mejoradores;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Parsers.CondicionDeMejoraParser;
import edu.fiuba.algo3.modelo.Parsers.CondicionDeMejoraTarot;
import edu.fiuba.algo3.modelo.Parsers.ParserDeMejora;
import edu.fiuba.algo3.modelo.Parsers.ParserDeMejoraTarot;

import javax.swing.*;

public class Comodin implements IMejorador, ICarta{
    private String nombre;
    private String descripcion;
    private ICondicionMejora activacion; // parsear a IcondicionMejora
    private Mejora efecto;
    public Comodin() {}

    public Comodin(String nombre, Mejora mejora, ICondicionMejora activacion, String contexto, String elemento) {
        this.nombre = nombre;
        this.activacion = activacion;
        this.efecto = mejora;
    }

    @JsonCreator
    public Comodin(@JsonProperty("nombre") String nombre, @JsonProperty("descripcion") String descripcion, @JsonProperty("activacion")Object activacion, @JsonProperty("efecto") Mejora mejora){
        this.nombre = nombre;
        this.descripcion = descripcion;
        CondicionDeMejoraParser parserAIcondicionDeMejora= new CondicionDeMejoraParser();
        this.activacion = parserAIcondicionDeMejora.parsear(activacion);
        this.efecto = mejora;
        ParserDeMejora parserDeMejora = new ParserDeMejora();
        IMejora efecto = parserDeMejora.parseDescripcion(descripcion);
        this.efecto.setMejora(efecto);
    }

    @Override
    public void mejorar(IMejorable mejorable) {
        this.activacion.aplicarMejora(mejorable, this.efecto,"","");

    }

    public void setActivacion(ICondicionMejora activacion) {
        this.activacion = activacion;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String getImagen() {
        return "/images/jokers/jokerSimple.png";
    }

    @Override
    public void asignarAComprador(IComprador comprador) {
        comprador.comprarComodin(this);
    }
    //public void setComodines(List<Comodin> comodines) {this.comodines = comodines;}

    @Override
    public ICarta getCarta(){
        return this;
    }

}



