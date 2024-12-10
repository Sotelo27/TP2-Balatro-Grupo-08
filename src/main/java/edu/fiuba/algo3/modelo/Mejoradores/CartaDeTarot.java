package edu.fiuba.algo3.modelo.Mejoradores;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.fiuba.algo3.modelo.IComprador;
import edu.fiuba.algo3.modelo.ICondicionMejora;
import edu.fiuba.algo3.modelo.ICarta;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.Parsers.CondicionDeMejoraParser;
import edu.fiuba.algo3.modelo.Parsers.CondicionDeMejoraTarot;
import edu.fiuba.algo3.modelo.Parsers.ParserDeMejora;
import edu.fiuba.algo3.modelo.Parsers.ParserDeMejoraTarot;

public class CartaDeTarot implements IMejorador, ICarta{
    private String nombre;
    private String descripcion;
    private Mejora mejora;
    private ICondicionMejora condicion;
    private String sobre;
    private String ejemplar;

    @JsonCreator
    public CartaDeTarot(@JsonProperty("nombre") String nombre, @JsonProperty("descripcion") String descripcion, @JsonProperty("efecto") Mejora mejora, @JsonProperty("sobre") String sobre, @JsonProperty("ejemplar") String ejemplar){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sobre = sobre;
        this.mejora = mejora;
        ParserDeMejoraTarot parserDeMejora = new ParserDeMejoraTarot();
        IMejora efecto = parserDeMejora.parseDescripcion(descripcion);
        this.mejora.setMejora(efecto);
        this.ejemplar = ejemplar;
        CondicionDeMejoraTarot parserDeTarot = new CondicionDeMejoraTarot();
        this.condicion = parserDeTarot.parsear(sobre,ejemplar);
    }

    @Override
    public void mejorar(IMejorable mejorable){
        this.condicion.aplicarMejora(mejorable, this.mejora,this.sobre,this.ejemplar);
    }

    public ICarta getCarta(){
        return this;
    }

    //Setters

    public void setSobre(ICarta unMejorable) {
        this.ejemplar = unMejorable.getNombre();
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
        return "/images/JojoTarots/"+nombre+".png";
    }

    @Override
    public void asignarAComprador(IComprador comprador) {
        comprador.comprarCartaDeTarot(this);
    }
}