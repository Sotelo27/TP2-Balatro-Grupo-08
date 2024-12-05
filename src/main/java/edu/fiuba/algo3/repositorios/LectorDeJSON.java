package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;

import java.io.File;
import java.io.IOException;
import java.util.List;



public class LectorDeJSON {
    public Mazo construirMazo() throws IOException {
        JsonMazoReader jsonMazoReader = new JsonMazoReader();
        return jsonMazoReader.readMazo();
    }

    public List<Ronda> construirRondas() throws  IOException {
        JsonBalatroReader jsonBalatroReader = new JsonBalatroReader();
        return jsonBalatroReader.readBalatro();
    }
}
