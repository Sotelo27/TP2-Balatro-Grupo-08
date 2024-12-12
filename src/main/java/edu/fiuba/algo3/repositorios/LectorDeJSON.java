package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class LectorDeJSON {
    private File archivo;


    public LectorDeJSON(String path) {
        this.archivo = new File(path);
    }

    public LectorDeJSON(){

    }

    public <T> List<T> obtenerInformacionDe(String seccion) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(this.archivo);
        JsonNode rondaNode = root.path("seccion");

        return null;
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
