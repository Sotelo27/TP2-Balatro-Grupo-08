package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    public List<Carta> readMazo() throws IOException {
        // Usamos la ruta relativa para acceder al archivo
        File file = new File(getClass().getClassLoader().getResource("json/mazo.json").getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        MazoPrueba mazo = objectMapper.readValue(file, MazoPrueba.class);

        // Imprimir las cartas para verificar la lectura
        mazo.getMazo().forEach(carta -> System.out.println(carta.getNombre() + " de " + carta.getPalo()));

        return mazo.getMazo();
    }
}



