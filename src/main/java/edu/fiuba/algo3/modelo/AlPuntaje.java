package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AlPuntaje extends CategoriaComodin {
    String descripcion;
    List<Comodin> comodines;
}
