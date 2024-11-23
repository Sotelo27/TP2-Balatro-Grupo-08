package edu.fiuba.algo3.repositorios;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import edu.fiuba.algo3.modelo.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonComodinReader {

    public List<Comodin> readComodines() throws IOException {
        // Ruta al archivo
        File file = new File(getClass().getClassLoader().getResource("json/comodines.json").getFile());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode comodinNode = root.get("Bonus por Mano Jugada").get("comodines");
        if (comodinNode.isArray()) {
            // Mapea el JSON directamente a una lista de objetos Tarot
            List<Comodin> comodines = mapper.convertValue(comodinNode, new TypeReference<List<Comodin>>() {});
            for (Comodin comodin : comodines) {
                System.out.println("Nombre: " + comodin.getNombre());
                System.out.println("Descripción: " + comodin.getDescripcion());
                System.out.println("Activación: " + comodin.getActivacion());
                System.out.println("Efecto: Puntos = " + comodin.getEfecto().getPuntos() +
                        ", Multiplicador = " + comodin.getEfecto().getMultiplicador());
                System.out.println("--------------------------------------");
            }
            return comodines;
        }

        throw new IOException("El nodo 'tarots' no es un arreglo.");
    }
}



