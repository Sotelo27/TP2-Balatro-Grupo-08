package edu.fiuba.algo3.modelo.Mejoradores;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.*;

import java.util.List;

public class Comodin implements IMejorador{
    private String nombre;
    private String descripcion;
    private ICondicionMejora activacion; // parsear a IcondicionMejora
    private Mejora efecto;

    public Comodin() {}

    @Override
    public void mejorar(IMejorable mejorable) {
        //Por ahi hay que modificar para que se haga directamente adentro mejorable (Jugada, Descarte, Comb o Carta), Refactorizable
        this.activacion.aplicarMejora(mejorable, this.efecto);
        // }
        // for(Comodin comodin : this.comodines) { <-- Esto va en combinacionDeComodines
        //     comodin.mejorar(mejorable);
        // }


    }




    //Setters solo para creacion

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion;}

    public void setActivacion(Object activacion) {
        //CondicionDeMejoraParser parserAIcondicionDeMejora= new CondicionDeMejoraParser();
        //this.activacion = parserAIcondicionDeMejora.parsear(activacion);

    }

    public void setEfecto(Mejora mejora) { 

        //ParserDeMejora parser= new ParserDeMejora();

       // this.mejora.setMejora(parser.parse(descripcion));

    }
    //public void setComodines(List<Comodin> comodines) {this.comodines = comodines;}


}



