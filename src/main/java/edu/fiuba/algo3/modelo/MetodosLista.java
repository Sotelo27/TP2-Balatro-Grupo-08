package edu.fiuba.algo3.modelo;

import java.util.*;


public interface MetodosLista {

    default void ordenarPorPalo(List <Carta> cartas) {

        cartas.sort(Comparator.comparingInt(Carta::devolverRank));

    };

    default void ordenarPorValor(List <Carta> cartas) {
        cartas.sort(Comparator.comparing(Carta::devolverPalo));

    };



};









