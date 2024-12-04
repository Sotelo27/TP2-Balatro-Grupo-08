package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.Tienda;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonBalatroReader {
    private static final String PATH = "json/balatro.json";

    public List<Ronda> readBalatro() throws IOException {
        // Cargar el recurso como InputStream
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PATH);
        if (inputStream == null) {
            throw new IOException("El archivo " + PATH + " no se encuentra en el classpath.");
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(inputStream);
        List<Ronda> rondas = new ArrayList<>();
        List<CartaDeTarot> tarots = new ArrayList<>();
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

                // Leer y asignar la tienda
                JsonNode tiendaNode = rondaJson.path("tienda");
                Tienda tienda = new Tienda();
                if (!tiendaNode.isMissingNode()) {
                    JsonNode comodinesNode = tiendaNode.path("comodines");
                    if (comodinesNode.isArray()) {
                        for (JsonNode comodinNode : comodinesNode) {
                            // Verificar si este comodín tiene otra lista de comodines
                            JsonNode subComodinesNode = comodinNode.path("comodines");
                            if (subComodinesNode.isArray()) {
                                CombinacionDeComodines combinacionComodin = mapper.convertValue(comodinNode, CombinacionDeComodines.class);
                                tienda.setCombinacion(combinacionComodin);
                            } else {
                                Comodin comodin = mapper.convertValue(comodinNode, Comodin.class);
                                tienda.setComodin(comodin);
                            }
                        }
                    }
                    JsonNode tarotsNode = tiendaNode.path("tarots");
                    if (tarotsNode.isArray()) {
                        for (JsonNode tarotNode : tarotsNode) {
                            CartaDeTarot tarot = mapper.convertValue(tarotNode, CartaDeTarot.class);
                            tarots.add(tarot);
                        }
                    }
                }
                tienda.setTarots(tarots);
                ronda.setTienda(tienda);
                rondas.add(ronda);
            }
        }
        return rondas;
    }
}
