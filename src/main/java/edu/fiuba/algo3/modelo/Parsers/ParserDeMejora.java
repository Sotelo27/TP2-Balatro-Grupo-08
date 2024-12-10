package edu.fiuba.algo3.modelo.Parsers;

import edu.fiuba.algo3.modelo.Mejoras.*;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
public class ParserDeMejora {

    public IMejora parseDescripcion(String descripcion) {
        String[] palabras = descripcion.split(" ");
        char caracterSigno = palabras[0].charAt(0);
        String funcion = "";
        if (palabras.length > 1){
            funcion = palabras[1];
        }
        if (caracterSigno == '+') {
            if (funcion.equals("puntos") || funcion.equals("fichas")) {
                return new SumaPuntos();
            } else {
                return new SumaAMultiplicador();
            }
        } else if (caracterSigno == 'x') {
            if (funcion.equals("puntos")) {
                return new MultiplicaPuntos();
            } else  {
                return new MultiplicaMultiplicador();
            }
        }

        return null;
    }

}

