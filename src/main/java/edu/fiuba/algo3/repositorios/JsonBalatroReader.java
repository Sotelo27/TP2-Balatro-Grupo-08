package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.Tienda;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonBalatroReader {
    private static final String PATH = "src/test/resources/json/balatro.json";
    private final JsonTiendaReader tiendaReader;

    public JsonBalatroReader() {
        this.tiendaReader = new JsonTiendaReader();
    }

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

                Tienda tienda = tiendaReader.leerTienda(rondaJson.path("tienda"), mapper);
                ronda.setTienda(tienda);

                rondas.add(ronda);
            }
        }
        return rondas;
    }
}

