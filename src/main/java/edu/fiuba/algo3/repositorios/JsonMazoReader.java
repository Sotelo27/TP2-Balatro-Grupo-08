package edu.fiuba.algo3.repositorios;
import edu.fiuba.algo3.modelo.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonMazoReader {
    private static final String PATH = "json/mazo.json";
    public Mazo readMazo() throws IOException {
        // Usamos la ruta relativa para acceder al archivo

        File file = new File(getClass().getClassLoader().getResource(PATH).getFile());

        ObjectMapper objectMapper = new ObjectMapper();

        Mazo mazo = objectMapper.readValue(file, Mazo.class);

        return mazo;
    }
}
