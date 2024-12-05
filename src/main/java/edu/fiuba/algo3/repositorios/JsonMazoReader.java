package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonMazoReader {
    private static final String PATH = "json/mazo.json";

    public Mazo readMazo() throws IOException {
        // Carga el recurso como un InputStream
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PATH);
        if (inputStream == null) {
            throw new IOException("El archivo " + PATH + " no se encuentra en el classpath.");
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(inputStream);
        JsonNode mazoNode = root.get("mazo");
        if (mazoNode.isArray()) {
            // Mapea el JSON directamente a una lista de objetos CartaDePoker
            List<CartaDePoker> cartas = mapper.convertValue(mazoNode, new TypeReference<List<CartaDePoker>>() {});
            Mazo mazo = new Mazo(cartas);
            return mazo;
        }

        throw new IOException("El nodo 'mazo' no es un arreglo.");
    }
}
