package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.ICarta;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Tienda;
import edu.fiuba.algo3.modelo.CartaDePoker;

import java.util.ArrayList;
import java.util.List;

public class JsonTiendaReader {

    public Tienda leerTienda(JsonNode tiendaNode, ObjectMapper mapper) {
        Tienda tienda = new Tienda();
        List<ICarta> especiales = new ArrayList<>();
        if (!tiendaNode.isMissingNode()) {
            JsonNode comodinesNode = tiendaNode.path("comodines");
            if (comodinesNode.isArray()) {
                for (JsonNode comodinNode : comodinesNode) {
                    // Verificar si este comodín tiene otra lista de comodines
                    JsonNode subComodinesNode = comodinNode.path("comodines");
                    if (subComodinesNode.isArray()) {
                        String nombre = comodinNode.path("nombre").asText();
                        String descripcion = comodinNode.path("descripcion").asText();
                        List<Comodin> subComodines = new ArrayList<>();
                        for(JsonNode subComodinNode : subComodinesNode) {
                            Comodin comodin = mapper.convertValue(subComodinNode, Comodin.class);
                            subComodines.add(comodin);
                        }
                        CombinacionDeComodines combinacionComodin = new CombinacionDeComodines(nombre,descripcion,subComodines);
                        especiales.add(combinacionComodin);
                    } else {
                        Comodin comodin = mapper.convertValue(comodinNode, Comodin.class);
                        especiales.add(comodin);
                    }
                }
            }
            JsonNode tarotsNode = tiendaNode.path("tarots");
            if (tarotsNode.isArray()) {
                for (JsonNode tarotNode : tarotsNode) {
                    CartaDeTarot tarot = mapper.convertValue(tarotNode, CartaDeTarot.class);
                    especiales.add(tarot);
                }
            }
            JsonNode cartaNode = tiendaNode.path("carta");
            if (cartaNode != null) {
                CartaDePoker carta = mapper.convertValue(cartaNode, CartaDePoker.class);
                especiales.add(carta);
            }
            tienda.setCartas(especiales);
        }
        return tienda;
    }
}
