package edu.fiuba.algo3.repositorios;
import edu.fiuba.algo3.modelo.Mejoradores.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonTarotReader {
    private static final String PATH = "src/test/resources/json/tarots.json";
    public List<CartaDeTarot> readTarots() throws IOException {
        // Ruta al archivo
        File file = new File((PATH));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode tarotsNode = root.get("tarots");
        if (tarotsNode.isArray()) {
            // Mapea el JSON directamente a una lista de objetos Tarot
            List<CartaDeTarot> tarots = mapper.convertValue(tarotsNode, new TypeReference<List<CartaDeTarot>>() {});

            return tarots;
        }

        throw new IOException("El nodo 'tarots' no es un arreglo.");
    }
}

