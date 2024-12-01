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
        public List<CartaDePoker> construirMazo() throws IOException {
            JsonMazoReader jsonMazoReader = new JsonMazoReader();
            return jsonMazoReader.readMazo();
        }

        public List<Ronda> construirBalatro() throws IOException {
            JsonBalatroReader jsonBalatroReader = new JsonBalatroReader();
            return jsonBalatroReader.readBalatro();
        }

        public List<CartaDeTarot> construirTarots() throws IOException {
            JsonTarotReader jsonTarotReader = new JsonTarotReader();
            return jsonTarotReader.readTarots();
        }

        public List<Comodin> construirComodins() throws IOException {
            JsonComodinReader jsonComodinReader = new JsonComodinReader();
            return jsonComodinReader.readComodines();
        }

        public List<CombinacionDeComodines> construirCombinaciones() throws IOException {
            JsonComodinReader jsonComodinReader = new JsonComodinReader();
            return jsonComodinReader.readCombinaciones();
        }

}
