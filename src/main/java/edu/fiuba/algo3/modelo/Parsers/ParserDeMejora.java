package edu.fiuba.algo3.modelo.Parsers;

import edu.fiuba.algo3.modelo.Mejoras.*;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
public class ParserDeMejora {

    public IMejora parseCondicion(String descripcion) {
        String[] palabras = descripcion.split(" ");
        char caracterSigno = palabras[0].charAt(0);
        String funcion = palabras[1];

        if (caracterSigno == '+') {
            if (funcion.equals("puntos")) {
                return new SumaPuntos();
            } else if (funcion.equals("Mult") || funcion.equals("multiplicacion") || palabras[2].equals("multiplicador")) {
                return new SumaAMultiplicador();
            } else if (funcion.equals("fichas")) {
                return new SumaFichas();
            }
        } else if (caracterSigno == 'x') {
            if (funcion.equals("puntos")) {
                return new MultiplicaPuntos();
            } else if (funcion.equals("Mult") || funcion.equals("multiplicacion") || palabras[2].equals("multiplicador")) {
                return new MultiplicaMultiplicador();
            }
        }

        return null;
    }

}

