package edu.fiuba.algo3.repositorios;
import edu.fiuba.algo3.modelo.Mejoradores.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonComodinReader {
    private static final String PATH = "json/comodines.json";
    private final ObjectMapper mapper = new ObjectMapper();

    private JsonNode readJsonNode() throws IOException {
        return mapper.readTree(new File(getClass().getClassLoader().getResource(PATH).getFile()));
    }

    public List<Comodin> readComodines() throws IOException {
        JsonNode root = readJsonNode();
        List<Comodin> allComodines = new ArrayList<>();

        for (Iterator<Map.Entry<String, JsonNode>> it = root.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> field = it.next();
            JsonNode categoriaNode = field.getValue();
            List<Comodin> comodin = mapper.convertValue(categoriaNode.get("comodines"), new TypeReference<List<Comodin>>() {});
            allComodines.addAll(comodin);
        }

        return allComodines;
    }
}





