package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.Balatro;

import java.io.File;
import java.io.IOException;

public class JsonBalatroReader {

    public Balatro readBalatro() throws IOException{

        File file = new File(getClass().getClassLoader().getResource("json/balatro.json").getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.readValue(file, Balatro.class);
    }
}
