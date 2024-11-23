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
                // Crear la instancia usando el método fábrica
                CategoriaComodin categoria = CategoriaComodin.crearDesdeNombre(categoriaNombre);

                // Configurar la descripción (si está presente en el JSON)
                if (field.getValue().has("descripcion")) {
                    categoria.setDescripcion(field.getValue().get("descripcion").asText());
                }

                // Leer los comodines de la categoría
                JsonNode comodinesNode = field.getValue().get("comodines");
                if (comodinesNode != null && comodinesNode.isArray()) {
                    List<Comodin> comodines = mapper.convertValue(comodinesNode, new TypeReference<List<Comodin>>() {});
                    categoria.setComodines(comodines);
                }

                // Agregar la categoría a la lista
                categorias.add(categoria);

                // Imprimir la categoría para depuración
                System.out.println("Categoría creada: " + categoria.getNombreCategoria());
                System.out.println("Descripción: " + categoria.getDescripcion());
                if (categoria.getComodines() != null) {
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
}




