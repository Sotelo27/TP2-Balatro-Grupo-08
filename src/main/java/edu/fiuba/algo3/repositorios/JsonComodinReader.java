package edu.fiuba.algo3.repositorios;

import edu.fiuba.algo3.modelo.Mejoradores.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonComodinReader {
    private static final String PATH = "src/test/resources/json/comodines.json";
    private final ObjectMapper mapper = new ObjectMapper();

    private JsonNode readJsonNode() throws IOException {
        return mapper.readTree(new File(PATH));
    }

    public List<Comodin> readComodines() throws IOException {
        JsonNode root = readJsonNode();
        List<Comodin> allComodines = new ArrayList<>();

        for (Iterator<Map.Entry<String, JsonNode>> it = root.fields(); it.hasNext(); ) {
            Map.Entry<String,JsonNode> field = it.next();
            if(!field.getKey().equals("Combinación")){
                JsonNode categoriaNode = field.getValue();
                List<Comodin> comodin = mapper.convertValue(categoriaNode.get("comodines"), new TypeReference<List<Comodin>>() {});
                allComodines.addAll(comodin);
            }
        }
        return allComodines;
    }
    public List<CombinacionDeComodines> readCombinaciones() throws IOException {
        // Ruta al archivo
        File file = new File((PATH));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode combinacionesNode = root.get("Combinación").get("comodines");
        List<CombinacionDeComodines> combinaciones = new ArrayList<>();
        if (combinacionesNode != null && combinacionesNode.isArray()) {
            for (JsonNode comodinNode : combinacionesNode) {
                // Verificar si este comodín tiene otra lista de comodines
                JsonNode subComodinesNode = comodinNode.path("comodines");
                if (subComodinesNode.isArray()) {
                    String nombre = comodinNode.path("nombre").asText();
                    String descripcion = comodinNode.path("descripcion").asText();
                    List<Comodin> subComodines = new ArrayList<>();
                    for (JsonNode subComodinNode : subComodinesNode) {
                        Comodin comodin = mapper.convertValue(subComodinNode, Comodin.class);
                        subComodines.add(comodin);
                    }
                    CombinacionDeComodines combinacionComodin = new CombinacionDeComodines(nombre, descripcion, subComodines);
                    combinaciones.add(combinacionComodin);
                }
            }
            return combinaciones;
        }
        throw new IOException("El nodo 'combinaciones' no es un arreglo.");
    }
}





