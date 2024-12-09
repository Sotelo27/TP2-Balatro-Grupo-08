package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.*;

import java.io.File;
import java.io.IOException;

public class JsonMazoReader {
    private static final String PATH = "src/test/resources/json/mazo.json";

    public Mazo readMazo() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Leemos el archivo JSON y lo deserializamos en un objeto Mazo
        File file = new File(PATH);  // Asumiendo que el archivo se llama "mazo.json"
        Mazo mazo = objectMapper.readValue(file, Mazo.class);
        // Imprimimos las cartas para verificar que se hayan leído correctamente
        return mazo;
    }
}
