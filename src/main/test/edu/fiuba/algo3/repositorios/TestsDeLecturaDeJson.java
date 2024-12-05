package edu.fiuba.algo3.repositorios;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

public class TestsDeLecturaDeJson {
    @Test
    public void verificarJsonReader() throws IOException {
        JsonMazoReader jsonReader = new JsonMazoReader();
        jsonReader.readMazo();
    }
    @Test
    public void verificarBalatroReader() throws IOException {
        JsonBalatroReader jsonReader = new JsonBalatroReader();
        jsonReader.readBalatro();
    }

    @Test
    public void verificarTarotReader() throws IOException {
        JsonTarotReader jsonReader = new JsonTarotReader();
        jsonReader.readTarots();
    }

    @Test
    public void verificaComodinReader() throws IOException {
        JsonComodinReader jsonReader = new JsonComodinReader();
        List<Comodin> mazo = jsonReader.readComodines();
    }
    @Test
    public void verificaCombinacionesReader() throws IOException {
        JsonComodinReader jsonReader = new JsonComodinReader();
        List<CombinacionDeComodines> mazo = jsonReader.readCombinaciones();
    }
}


