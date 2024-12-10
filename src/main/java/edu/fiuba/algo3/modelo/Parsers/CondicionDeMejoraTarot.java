package edu.fiuba.algo3.modelo.Parsers;

import edu.fiuba.algo3.modelo.CondicionesDeMejora.*;
import edu.fiuba.algo3.modelo.ICondicionMejora;

import java.util.Map;
import java.util.Random;

public class CondicionDeMejoraTarot {

    public ICondicionMejora parsear(String sobre, String elemento) {

        //implemetar parser
        if(sobre != null) {
            if (sobre.equals("mano")) {
                return new RestriccionACombinacion(elemento);
            }
            if (sobre.equals("carta")) {
                return new RestriccionACarta(elemento);
            }
        }

        return null;
    }
}
