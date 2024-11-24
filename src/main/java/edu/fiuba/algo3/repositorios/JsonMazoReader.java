package edu.fiuba.algo3.repositorios;
import edu.fiuba.algo3.modelo.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonMazoReader {

    public MazoPrueba readMazo() throws IOException {
        // Usamos la ruta relativa para acceder al archivo

        File file = new File(getClass().getClassLoader().getResource("json/mazo.json").getFile());

        ObjectMapper objectMapper = new ObjectMapper();

        MazoPrueba mazo = objectMapper.readValue(file, MazoPrueba.class);

        return mazo;
    }
}
