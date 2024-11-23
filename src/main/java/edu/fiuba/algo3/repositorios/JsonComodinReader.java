package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonComodinReader {

    // Mapa para asociar nombres de categoría con las clases concretas
    private static final Map<String, Class<? extends CategoriaComodin>> CATEGORIAS_MAP = new HashMap<>();

    private List<Comodin> procesarComodinesAnidados(JsonNode nodo, ObjectMapper mapper) {
        List<Comodin> comodines = new ArrayList<>();

        for (JsonNode comodinNode : nodo) {
            Comodin comodin = mapper.convertValue(comodinNode, Comodin.class);

            // Si el comodín tiene una lista anidada, procesarla recursivamente
            JsonNode subComodinesNode = comodinNode.get("comodines");
            if (subComodinesNode != null && subComodinesNode.isArray()) {
                List<Comodin> subComodines = procesarComodinesAnidados(subComodinesNode, mapper);
                comodin.setComodines(subComodines); // Asumimos que la clase Comodin tiene un atributo para esto
            }

            comodines.add(comodin);
        }

        return comodines;
    }


    public List<CategoriaComodin> readComodines() throws IOException {
        // Ruta al archivo
        File file = new File(getClass().getClassLoader().getResource("json/comodines.json").getFile());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);

        // Lista para almacenar las instancias de CategoriaComodin
        List<CategoriaComodin> categorias = new ArrayList<>();

        // Iterar sobre las categorías
        Iterator<Map.Entry<String, JsonNode>> fields = root.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String categoriaNombre = field.getKey().toLowerCase();
            System.out.println("Categoría nombre es: " + categoriaNombre);

            try {
                CategoriaComodin categoria;

                // Caso especial para "Combinación"
                if ("combinación".equals(categoriaNombre)) {
                    categoria = new Combinacion();

                    // Configurar descripción
                    if (field.getValue().has("descripcion")) {
                        categoria.setDescripcion(field.getValue().get("descripcion").asText());
                    }

                    // Procesar comodines anidados
                    JsonNode comodinesNode = field.getValue().get("comodines");
                    if (comodinesNode != null && comodinesNode.isArray()) {
                        List<Comodin> comodinesAnidados = procesarComodinesAnidados(comodinesNode, mapper);
                        ((Combinacion) categoria).setComodines(comodinesAnidados);
                    }
                } else {
                    // Crear la instancia para otras categorías
                    categoria = CategoriaComodin.crearDesdeNombre(categoriaNombre);

                    // Configurar descripción
                    if (field.getValue().has("descripcion")) {
                        categoria.setDescripcion(field.getValue().get("descripcion").asText());
                    }

                    // Leer comodines
                    JsonNode comodinesNode = field.getValue().get("comodines");
                    if (comodinesNode != null && comodinesNode.isArray()) {
                        List<Comodin> comodines = mapper.convertValue(comodinesNode, new TypeReference<List<Comodin>>() {});
                        categoria.setComodines(comodines);
                    }
                }

                categorias.add(categoria);

                // Depuración
                System.out.println("Categoría creada: " + categoria.getNombreCategoria());
                if (categoria instanceof Combinacion) {
                    List<Comodin> comodinesAnidados = ((Combinacion) categoria).getComodines();
                    comodinesAnidados.forEach(comodin -> System.out.println(" - " + comodin.getNombre()));
                } else if (categoria.getComodines() != null) {
                    categoria.getComodines().forEach(comodin -> System.out.println(" - " + comodin.getNombre()));
                }
                System.out.println("--------------------------------------");

            } catch (Exception e) {
                System.err.println("Error al crear la categoría: " + categoriaNombre);
                e.printStackTrace();
            }
        }

        return categorias;
    }

    public MazoCombinacion readCombinaciones() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("json/comodines.json").getFile());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode mixNode = root.get("Combinación");
        return mapper.convertValue(mixNode, MazoCombinacion.class);
    }

}




