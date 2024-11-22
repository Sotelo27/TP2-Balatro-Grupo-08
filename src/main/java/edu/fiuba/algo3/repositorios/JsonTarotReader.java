package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.TarotPrueba;

import java.io.File;
import java.io.IOException;


public class JsonTarotReader {
    public void readTarots() throws IOException {
        // Usamos la ruta relativa para acceder al archivo
        File file = new File(getClass().getClassLoader().getResource("json/tarots.json").getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        TarotPrueba cartaTarot = objectMapper.readValue(file, TarotPrueba.class);

        // Imprimir las cartas para verificar la lectura
        System.out.println(cartaTarot.toString());

    }
}
