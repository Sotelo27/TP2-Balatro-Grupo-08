package edu.fiuba.algo3.modelo;

import java.util.*;


public interface MetodosLista {

    default void ordenarPorPalo(List <CartaDePoker> cartas) {

        //cartas.sort(Comparator.comparingInt(Carta::devolverRank));

    };

    default void ordenarPorValor(List <CartaDePoker> cartas) {
        //cartas.sort(Comparator.comparing(Carta::devolverPalo));

    };



};









