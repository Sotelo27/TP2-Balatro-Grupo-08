package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.EfectoPrueba;
import edu.fiuba.algo3.modelo.MazoTarots;


import java.io.File;
import java.io.IOException;


public class JsonTarotReader {
    public void readTarots() throws IOException {
        // Usamos la ruta relativa para acceder al archivo
        File file = new File(getClass().getClassLoader().getResource("json/tarots.json").getFile());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);

        JsonNode tarots = root.get("tarots");
        if(tarots.isArray()){
            for(JsonNode tarot : tarots){
                System.out.println(tarot.toString());
            }
        }
    }
}
