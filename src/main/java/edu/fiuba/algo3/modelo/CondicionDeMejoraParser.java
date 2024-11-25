package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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
                return new RestriccionACombinacion((String) activacionMap.get("Mano Jugada"));
            }
            if(activacionMap.containsKey("1 en")){
                return new ActivarAlAzar((int) activacionMap.get("1 en"));
            }


        }

        return new RestriccionACombinacion("Flush");
    }
}
