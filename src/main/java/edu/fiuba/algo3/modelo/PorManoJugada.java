package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PorManoJugada extends CategoriaComodin {
    private String descripcion;
    private List<Comodin> comodines;

}
