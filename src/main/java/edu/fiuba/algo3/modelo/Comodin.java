package edu.fiuba.algo3.modelo;

import java.util.List;

public class Comodin implements IMejorador{
    private String nombre;
    private String descripcion;
    private ICondicionMejora activacion; // parsear a IcondicionMejora
    private Mejora efecto;
    private List<Comodin> comodines;

    public Comodin() {}

    @Override
    public void mejorar(IMejorable mejorable) {
        //Por ahi hay que modificar para que se haga directamente adentro mejorable (Jugada, Descarte, Comb o Carta), Refactorizable
        if(this.activacion.validarCondicion(mejorable)){
            mejorable.recibirMejora(this.efecto);
        }
        for(Comodin comodin : this.comodines) {
            comodin.mejorar(mejorable);
        }


    }




    //Setters solo para creacion

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion;}

    public void setActivacion(Object activacion) {

        CondicionDeMejoraParser parserAIcondicionDeMejora= new CondicionDeMejoraParser();
        this.activacion = parserAIcondicionDeMejora.parsear(activacion);

    }

    public void setEfecto(Mejora efecto) { this.efecto = efecto; }

    public void setComodines(List<Comodin> comodines) {this.comodines = comodines;}


}



