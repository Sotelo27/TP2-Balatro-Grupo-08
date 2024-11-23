package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonComodinReader {
    List <CategoriaComodin> categorias;

    public JsonComodinReader() {categorias = new ArrayList <>();}

    public MazoCombinacion readCombinaciones() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("json/comodines.json").getFile());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode mixNode = root.get("Combinación");
        return mapper.convertValue(mixNode, MazoCombinacion.class);
    }

    public AlPuntaje readCategoriaAlPuntaje() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("json/comodines.json").getFile());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode puntajeNode = root.get("Al Puntaje");
        categorias.add(mapper.treeToValue(puntajeNode, AlPuntaje.class));
        return mapper.convertValue(puntajeNode,AlPuntaje.class);
    }
    public BonusPorDescarte readCategoriaDescarte() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("json/comodines.json").getFile());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode mixNode = root.get("Bonus por Descarte");
        categorias.add(mapper.treeToValue(mixNode, BonusPorDescarte.class));
        return mapper.convertValue(mixNode, BonusPorDescarte.class);
    }
    public ComodinAleatorio readCategoriaAleatorio() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("json/comodines.json").getFile());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode mixNode = root.get("Chance de activarse aleatoriamente");
        categorias.add(mapper.treeToValue(mixNode, ComodinAleatorio.class));
        return mapper.convertValue(mixNode, ComodinAleatorio.class);
    }
    public BonusPorManoJugada readCategoriaManoJugada() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("json/comodines.json").getFile());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode mixNode = root.get("Bonus por Mano Jugada");
        categorias.add(mapper.treeToValue(mixNode, BonusPorManoJugada.class));
        return mapper.convertValue(mixNode, BonusPorManoJugada.class);
    }

    public List<CategoriaComodin> getCategorias() {
        return categorias;
    }
}




