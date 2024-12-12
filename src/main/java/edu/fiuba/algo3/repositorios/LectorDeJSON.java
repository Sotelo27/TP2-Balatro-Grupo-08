package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class LectorDeJSON {
    private JsonNode nodoBusqueda;
    private ObjectMapper mapper;

    public LectorDeJSON(String path) {
        mapper = new ObjectMapper();
        try(FileReader reader = new FileReader(new File(path))){
            nodoBusqueda = mapper.readTree(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LectorDeJSON(){

    }

    public void obtenerInformacionDe(String seccion) {
        JsonNode jsonArray = nodoBusqueda.path(seccion);
        try {
            if ("rondas".equals(seccion)) {
                construirRondas();
            } else {
                //return mapper.readValue(jsonArray.traverse(), new TypeReference<List<CartaDTO>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Mazo construirMazo() throws IOException {
        JsonMazoReader jsonMazoReader = new JsonMazoReader();
        return jsonMazoReader.readMazo();
    }

    public List<Ronda> construirRondas() throws  IOException {
        JsonBalatroReader jsonBalatroReader = new JsonBalatroReader();
        return jsonBalatroReader.readBalatro();
    }

    public List<CartaDeTarot> construirTarots() throws IOException {
        JsonTarotReader jsonReader = new JsonTarotReader();
        return jsonReader.readTarots();
    }

    public List<Comodin> construirComodines() throws IOException {
        JsonComodinReader jsonReader = new JsonComodinReader();
        return jsonReader.readComodines();
    }
    public List<CombinacionDeComodines> contruirCombinacionesComodin() throws IOException {
        JsonComodinReader jsonReader = new JsonComodinReader();
        return jsonReader.readCombinaciones();
    }
}
