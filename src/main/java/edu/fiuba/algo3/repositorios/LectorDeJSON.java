package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;

public class LectorDeJSON implements IGameLoader{
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

    @Override
    public Mazo construirMazo() {
        JsonMazoReader jsonMazoReader = new JsonMazoReader();
        try {
            return jsonMazoReader.readMazo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ronda> construirRondas(){
        JsonBalatroReader jsonBalatroReader = new JsonBalatroReader();
        try {
            return jsonBalatroReader.readBalatro(nodoBusqueda,mapper);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CartaDeTarot> construirTarots() throws IOException {
        JsonTarotReader jsonReader = new JsonTarotReader();
        return jsonReader.readTarots();
    }

    public List<Comodin> construirComodines() throws IOException {
        JsonComodinReader jsonReader = new JsonComodinReader();
        return jsonReader.readComodines();
    }


}
