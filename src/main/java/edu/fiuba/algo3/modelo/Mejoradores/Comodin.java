package edu.fiuba.algo3.modelo.Mejoradores;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Parsers.CondicionDeMejoraParser;

public class Comodin implements IMejorador, ICarta{
    private String nombre;
    private String descripcion;
    private ICondicionMejora activacion; // parsear a IcondicionMejora
    private Mejora efecto;
    private String contexto;
    private String elemento;
    public Comodin() {}

    public Comodin(String nombre, Mejora mejora, ICondicionMejora activacion, String contexto, String elemento) {
        this.nombre = nombre;
        this.activacion = activacion;
        this.efecto = mejora;
        this.contexto = contexto;
        this.elemento = elemento;
    }

    @Override
    public void mejorar(IMejorable mejorable) {
        //Por ahi hay que modificar para que se haga directamente adentro mejorable (Jugada, Descarte, Comb o Carta), Refactorizable
        this.activacion.aplicarMejora(mejorable, this.efecto , this.contexto, this.elemento);
        // }
        // for(Comodin comodin : this.comodines) { <-- Esto va en combinacionDeComodines
        //     comodin.mejorar(mejorable);
        // }


    }




    //Setters solo para creacion

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion;}

    public void setActivacion(Object activacion) {
        CondicionDeMejoraParser parserAIcondicionDeMejora= new CondicionDeMejoraParser();
        this.activacion = parserAIcondicionDeMejora.parsear(activacion);

    }

    public void setEfecto(Mejora mejora) { 

        //ParserDeMejora parser= new ParserDeMejora();

       // this.mejora.setMejora(parser.parse(descripcion));

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



