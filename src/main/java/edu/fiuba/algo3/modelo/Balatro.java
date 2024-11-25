package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.fiuba.algo3.modelo.Estados.EstadoJuego;

import java.util.List;

@JsonIgnoreProperties("mazo")
public class Balatro {
    List<Ronda> rondas;
    Mazo mazo;
    EstadoJuego estado;

    public Balatro() {};

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public void setEstado(EstadoJuego estadoAsignar) {
        this.estado = estadoAsignar;
    }







}
