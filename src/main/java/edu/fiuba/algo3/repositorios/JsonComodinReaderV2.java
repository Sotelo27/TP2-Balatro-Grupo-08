package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.AlPuntaje;
import edu.fiuba.algo3.modelo.Comodin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonComodinReaderV2 {
    private final String PATH  = "json/comodines.json";

    public List<Comodin> readComodines() throws IOException {
        // Ruta al archivo
        File file = new File(getClass().getClassLoader().getResource(PATH).getFile());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode puntajeNode = root.get("Al Puntaje").get("comodines");
        if (puntajeNode.isArray()) {
            // Mapea el JSON directamente a una lista de objetos Tarot
            List<Comodin> comodines = mapper.convertValue(puntajeNode, new TypeReference<List<Comodin>>() {});
            for (Comodin comodin : comodines) {
                System.out.println("Nombre: " + comodin.getNombre());
                System.out.println("Descripción: " + comodin.getDescripcion());
                System.out.println("Activación: " + comodin.getActivacion());
                System.out.println("Efecto: Puntos = " + comodin.getEfecto().getPuntos() +
                        ", Multiplicador = " + comodin.getEfecto().getMultiplicador());
                System.out.println("--------------------------------------");
            }
        }
        JsonNode manoJugadaNode = root.get("Bonus por Mano Jugada").get("comodines");
        if (manoJugadaNode.isArray()) {
            // Mapea el JSON directamente a una lista de objetos Tarot
            List<Comodin> comodines = mapper.convertValue(manoJugadaNode, new TypeReference<List<Comodin>>() {});
            for (Comodin comodin : comodines) {
                System.out.println("Nombre: " + comodin.getNombre());
                System.out.println("Descripción: " + comodin.getDescripcion());
                System.out.println("Activación: " + comodin.getActivacion());
                System.out.println("Efecto: Puntos = " + comodin.getEfecto().getPuntos() +
                        ", Multiplicador = " + comodin.getEfecto().getMultiplicador());
                System.out.println("--------------------------------------");
            }
        }

        throw new IOException("El nodo 'tarots' no es un arreglo.");
    }

    public AlPuntaje readAlPuntaje() throws IOException {
        File file = new File(getClass().getClassLoader().getResource(PATH).getFile());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        JsonNode puntajeNode = root.get("Al Puntaje");
        return mapper.convertValue(puntajeNode,AlPuntaje.class);
        }
    }

