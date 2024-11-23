package edu.fiuba.algo3.repositorios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.MazoTarots;
import edu.fiuba.algo3.modelo.TarotPrueba;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonTarotReader {
    public MazoTarots readTarots() throws IOException {
        // Ruta al archivo
        File file = new File(getClass().getClassLoader().getResource("json/tarots.json").getFile());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        MazoTarots mazoTarots = new MazoTarots();
        JsonNode tarotsNode = root.get("tarots");
        if (tarotsNode.isArray()) {
            // Mapea el JSON directamente a una lista de objetos Tarot
            List<TarotPrueba> tarots = mapper.convertValue(tarotsNode, new TypeReference<List<TarotPrueba>>() {});

            // Imprime cada objeto Tarot para verificar
            for (TarotPrueba tarot : tarots) {
                System.out.println(tarot.getEjemplar()); // Aquí se imprime cada tarot
            }
            mazoTarots.setMazo(tarots);
            return mazoTarots;
        }

        throw new IOException("El nodo 'tarots' no es un arreglo.");
    }
}

