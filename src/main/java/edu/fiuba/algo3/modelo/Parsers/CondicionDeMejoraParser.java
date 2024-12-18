package edu.fiuba.algo3.modelo.Parsers;

import edu.fiuba.algo3.modelo.CondicionesDeMejora.ActivarAlAzar;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.EsDescarte;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.RestriccionACombinacion;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.SinRestriccion;
import edu.fiuba.algo3.modelo.ICondicionMejora;

import java.util.Map;
import java.util.Random;

public class CondicionDeMejoraParser {

    public ICondicionMejora parsear(Object activacion) {
        //implemetar parser
        if(activacion instanceof String){
            String texto = (String) activacion;

            if(texto.equals("Siempre")) {
                return new SinRestriccion();
            }
            if(texto.equals("Descarte")){
                return new EsDescarte();
            }
        }
        if(activacion instanceof Map ){
            Map activacionMap = (Map) activacion;
            if(activacionMap.containsKey("Mano Jugada")){
                String valor = activacionMap.get("Mano Jugada").toString();
                return new RestriccionACombinacion(valor);
            }
            if(activacionMap.containsKey("1 en")){
                String valor = activacionMap.get("1 en").toString();
                return new ActivarAlAzar(valor,new Random());
            }


        }

        return null;
    }
}
