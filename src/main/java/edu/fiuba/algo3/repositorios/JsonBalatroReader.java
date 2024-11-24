package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonBalatroReader {
    private static final String PATH = "json/balatro.json";
    public List<Ronda> readBalatro() throws IOException {
        // Ruta al archivo
        File file = new File(getClass().getClassLoader().getResource(PATH).getFile());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode rondaNode = root.get("rondas");
        if (rondaNode.isArray()) {
            // Mapea el JSON directamente a una lista de objetos Tarot
            List<Ronda> rondas = mapper.convertValue(rondaNode, new TypeReference<List<Ronda>>() {});

            return rondas;
        }

        throw new IOException("El nodo 'tarots' no es un arreglo.");
    }
}
