package edu.fiuba.algo3.modelo.Parsers;

import edu.fiuba.algo3.modelo.Mejoras.*;

public class ParserDeMejoraTarot {
    public IMejora parseDescripcion(String descripcion) {
        String[] palabras = descripcion.split(" ");
        String funcion = palabras[palabras.length - 1];
        if (funcion.equals("multicarta.") || funcion.equals("acero.") || funcion.equals("cristal")) {
            return new MultiplicaMultiplicador();
        } else if(funcion.equals("piedra") || funcion.equals("bonificacion")) {
            return new SumaPuntos();
        }
        return new ReemplazaPuntos();
    }
}
