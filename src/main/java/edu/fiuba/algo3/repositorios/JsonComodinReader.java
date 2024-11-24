package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonComodinReader {
    private final String PATH = "json/comodines.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private final List<CategoriaComodin> categorias = new ArrayList<>();

    public JsonComodinReader() {}

    private JsonNode readJsonNode() throws IOException {
        File file = new File(getClass().getClassLoader().getResource(PATH).getFile());
        return mapper.readTree(file);
    }

    public CategoriaComodin readCategoria(String categoryName, Class<? extends CategoriaComodin> clase) throws IOException {
        JsonNode root = readJsonNode();
        JsonNode categoryNode = root.get(categoryName);
        CategoriaComodin categoria = mapper.treeToValue(categoryNode, clase);
        categorias.add(categoria);
        return categoria;
    }

    public MazoCombinacion readCombinaciones() throws IOException {
        JsonNode root = readJsonNode();
        JsonNode mixNode = root.get("Combinación");
        return mapper.convertValue(mixNode, MazoCombinacion.class);
    }

    public AlPuntaje readCategoriaAlPuntaje() throws IOException {
        return (AlPuntaje) readCategoria("Al Puntaje", AlPuntaje.class);
    }

    public BonusPorDescarte readCategoriaDescarte() throws IOException {
        return (BonusPorDescarte) readCategoria("Bonus por Descarte", BonusPorDescarte.class);
    }

    public ComodinAleatorio readCategoriaAleatorio() throws IOException {
        return (ComodinAleatorio) readCategoria("Chance de activarse aleatoriamente", ComodinAleatorio.class);
    }

    public BonusPorManoJugada readCategoriaManoJugada() throws IOException {
        return (BonusPorManoJugada) readCategoria("Bonus por Mano Jugada", BonusPorManoJugada.class);
    }

    public List<CategoriaComodin> readCategorias() {
        return categorias;
    }
}





