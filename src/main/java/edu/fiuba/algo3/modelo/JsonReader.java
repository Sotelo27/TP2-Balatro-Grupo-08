package edu.fiuba.algo3.modelo;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class JsonReader {
    private Gson gson = new Gson();

    public void readMazo() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStreamReader reader = new InputStreamReader(classLoader.getResourceAsStream("mazo.json"));
        Mazo mazo = gson.fromJson(reader, Mazo.class);
        System.out.println(mazo.getCartas());
    }
}
