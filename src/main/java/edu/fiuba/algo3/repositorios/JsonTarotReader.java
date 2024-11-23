package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.Tarot;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonTarotReader {
    public List<Tarot> readTarots() throws IOException {
        // Ruta al archivo
        File file = new File(getClass().getClassLoader().getResource("json/tarots.json").getFile());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);

        JsonNode tarotsNode = root.get("tarots");
        if (tarotsNode.isArray()) {
            // Mapea el JSON directamente a una lista de objetos Tarot
            List<Tarot> tarots = mapper.convertValue(tarotsNode, new TypeReference<List<Tarot>>() {});

            // Imprime cada objeto Tarot para verificar
            for (Tarot tarot : tarots) {
                System.out.println(tarot.getNombre()); // Aquí se imprime cada tarot
            }
            return tarots;
        }

        throw new IOException("El nodo 'tarots' no es un arreglo.");
    }
}

