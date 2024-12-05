package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.Tienda;
import edu.fiuba.algo3.modelo.Mejoras.IMejorador;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonBalatroReader {
    private static final String PATH = "src/test/resources/json/balatro.json";

    public List<Ronda> readBalatro() throws IOException {
        // Cargar el recurso como InputStream
        File file = new File(PATH);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        List<Ronda> rondas = new ArrayList<>();
        JsonNode rondaNode = root.path("rondas");
        if (rondaNode.isArray()) {
            for (JsonNode rondaJson : rondaNode) {
                Ronda ronda = new Ronda();

                // Leer y asignar los valores
                int numero = rondaJson.path("nro").asInt();
                int manos = rondaJson.path("manos").asInt();
                int descartes = rondaJson.path("descartes").asInt();
                int puntajeASuperar = rondaJson.path("puntajeASuperar").asInt();

                ronda.setNumero(numero);
                ronda.setManos(manos);
                ronda.setDescartes(descartes);
                ronda.setPuntajeASuperar(puntajeASuperar);

                Tienda tienda = leerTienda(rondaJson.path("tienda"), mapper);
                ronda.setTienda(tienda);

                rondas.add(ronda);
            }
        }
        return rondas;
    }

    private Tienda leerTienda(JsonNode tiendaNode, ObjectMapper mapper) {
        Tienda tienda = new Tienda();
        List<IMejorador> especiales = new ArrayList<>();
        if (!tiendaNode.isMissingNode()) {
            JsonNode comodinesNode = tiendaNode.path("comodines");
            if (comodinesNode.isArray()) {
                for (JsonNode comodinNode : comodinesNode) {
                    // Verificar si este comodín tiene otra lista de comodines
                    JsonNode subComodinesNode = comodinNode.path("comodines");
                    if (subComodinesNode.isArray()) {
                        CombinacionDeComodines combinacionComodin = mapper.convertValue(comodinNode, CombinacionDeComodines.class);
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
            tienda.setCartasEspeciales(especiales);
        }
        return tienda;
    }
}

