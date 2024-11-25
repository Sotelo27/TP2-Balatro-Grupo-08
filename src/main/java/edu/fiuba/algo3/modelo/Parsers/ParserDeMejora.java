
package edu.fiuba.algo3.modelo.Parser;
import edu.fiuba.algo3.modelo;

import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
public class ParserDeMejora implements Parser {

    public IMejora parseCondicion(JsonNode efectoDelJson, String descripcion) {
    
        String[] palabras = descripcion.split(" ");
        String caracterSigno = palabras[0].charAt(0);
        String funcion =  palabras[1];
        if (caracterSigno == '+') {
            if (palabras[1].equals("puntos")) {
                return new SumaPuntos(efectoDelJson.get("puntos").asInt());

            } else if (palabras[1].equals("Mult") || (palabras[1].equals("multiplicacion") || (palabras[2].equals("multiplicador")) {
                return new SumaMultiplicador(efectoDelJson.get("multiplicador").asInt());
            
            } else if (palabras[1].equals("fichas")){
				return new SumaFichas(efectoDelJson.get("puntos").asInt());
            }
        if (caracterSigno == 'x') {
			if (palabras[1].equals("puntos")) {
                return new MultiplicaPuntos(efectoDelJson.get("multiplicador").asInt());

            } else if (palabras[1].equals("Mult") || (palabras[1].equals("multiplicacion") || (palabras[2].equals("multiplicador")) {
                return new SumaMultiplicador(efectoDelJson.get("multiplicador").asInt());
            
            } else if (palabras[1].equals("fichas")){
				return new SumaFichas(efectoDelJson.get("puntos").asInt());
            }
        

        return null;
    }
}
