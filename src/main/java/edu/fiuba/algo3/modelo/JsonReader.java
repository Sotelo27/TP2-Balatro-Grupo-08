package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    public List<Carta> readMazo() throws IOException {
        // Creamos un ObjectMapper para leer el archivo JSON
        ObjectMapper objectMapper = new ObjectMapper();
        // Leemos el archivo JSON y lo deserializamos en un objeto Mazo
        File file = new File("C:\\Users\\sotel\\OneDrive\\Escritorio\\Balatro\\TP2-Balatro-Grupo-08\\src\\test\\resources\\json\\mazo.json");  // Asumiendo que el archivo se llama "mazo.json"
        MazoPrueba mazo = objectMapper.readValue(file, MazoPrueba.class);

        // Imprimimos las cartas para verificar que se hayan leído correctamente
        mazo.getMazo().forEach(carta -> System.out.println(carta.getPuntos() + " de " + carta.getPalo()));

        return mazo.getMazo();
    }
}


