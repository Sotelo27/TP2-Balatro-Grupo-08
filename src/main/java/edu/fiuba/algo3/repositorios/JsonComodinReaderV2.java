package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.AlPuntaje;
import edu.fiuba.algo3.modelo.Comodin;
import edu.fiuba.algo3.modelo.PorManoJugada;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonComodinReaderV2 {
    private final String PATH  = "json/comodines.json";

    public AlPuntaje readAlPuntaje() throws IOException {
        File file = new File(getClass().getClassLoader().getResource(PATH).getFile());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode puntajeNode = root.get("Al Puntaje");
        return mapper.convertValue(puntajeNode,AlPuntaje.class);
        }

    public PorManoJugada readManoJugada() throws IOException {
        File file = new File(getClass().getClassLoader().getResource(PATH).getFile());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode manoJugadaNode = root.get("Bonus por Mano Jugada");
        return mapper.convertValue(manoJugadaNode,PorManoJugada.class);
    }
}


