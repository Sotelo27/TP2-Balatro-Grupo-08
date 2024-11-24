package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties("mazo")
public class Balatro {
    List<Ronda> rondas;
    MazoPrueba mazo;

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }

    public MazoPrueba getMazo() {
        return mazo;
    }

    public void setMazo(MazoPrueba mazo) {
        this.mazo = mazo;
    }
}
