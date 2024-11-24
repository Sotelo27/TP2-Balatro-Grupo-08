package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonComodinReader {
    private final String PATH = "json/comodines.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonComodinReader() {}

    private JsonNode readJsonNode() throws IOException {
        File file = new File(getClass().getClassLoader().getResource(PATH).getFile());
        return mapper.readTree(file);
    }


    public MazoCombinacion readCombinaciones() throws IOException {
        JsonNode root = readJsonNode();
        JsonNode mixNode = root.get("Combinación");
        return mapper.convertValue(mixNode, MazoCombinacion.class);
    }

    public MazoComodines readCategorias() throws IOException {
        JsonNode root = readJsonNode();  // Cargar el JSON desde un archivo o fuente
        Iterator<Map.Entry<String, JsonNode>> fields = root.fields();
        List<Comodin> allComodines = new ArrayList<>();
        String descripcionMazo = "";

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String categoriaNombre = field.getKey();
            JsonNode categoriaNode = field.getValue();

            System.out.println("Categoría creada: " + categoriaNombre);

            // Verificar que no sea la categoría "Combinacion"
            if (!categoriaNombre.equals("Combinación")) {
                // Extraer la descripción de la categoría
                descripcionMazo = categoriaNode.get("descripcion").asText();
                JsonNode tarotsNode = categoriaNode.get("comodines");

                // Convertir la lista de comodines en objetos Comodin
                List<Comodin> tarots = mapper.convertValue(tarotsNode, new TypeReference<List<Comodin>>() {});

                // Imprimir detalles de cada Comodin
                for (Comodin comodin : tarots) {
                    //System.out.println("Comodín: " + comodin.getNombre());
                    //System.out.println("Descripción: " + comodin.getDescripcion());
                    //System.out.println("Activación: " + comodin.getActivacion());
                    //System.out.println("Efecto: " + comodin.getEfecto());

                    // Añadir cada comodín a la lista de todos los comodines
                    allComodines.add(comodin);
                }
            }
        }

        // Crear el objeto MazoComodines con la lista de todos los comodines y la descripción
        MazoComodines mazo = new MazoComodines();
        mazo.setDescripcion(descripcionMazo);  // Asignar la descripción de la categoría
        mazo.setComodines(allComodines);  // Asignar la lista de todos los comodines
        System.out.println("Comodines en el mazo:");
        for (Comodin comodin : mazo.getComodines()) {
            System.out.println("Comodín: " + comodin.getNombre());
            System.out.println("Descripción: " + comodin.getDescripcion());
            System.out.println("Activación: " + comodin.getActivacion());
            System.out.println("Efecto: " + comodin.getEfecto());
            System.out.println();  // Línea en blanco para separar comodines
        }
        return mazo;
    }

}





