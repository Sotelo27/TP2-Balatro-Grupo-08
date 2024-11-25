package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonMazoReader{
    private static final String PATH = "json/mazo.json";
    public List<CartaDePoker> readMazo() throws IOException {
        // Ruta al archivo
        File file = new File(getClass().getClassLoader().getResource(PATH).getFile());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode tarotsNode = root.get("mazo");
        if (tarotsNode.isArray()) {
            // Mapea el JSON directamente a una lista de objetos Tarot
            List<CartaDePoker> tarots = mapper.convertValue(tarotsNode, new TypeReference<List<CartaDePoker>>() {});

            return tarots;
        }

        throw new IOException("El nodo 'tarots' no es un arreglo.");
    }
}
