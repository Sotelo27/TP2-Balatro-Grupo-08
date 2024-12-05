package edu.fiuba.algo3.repositorios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;

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
