package edu.fiuba.algo3.modelo;

import java.util.*;


public interface MetodosLista {

    default boolean sonDelMismoTipo(List <CartaDePoker> cartas){

        CartaDePoker primerCarta = cartas.get(0);
        for (CartaDePoker carta : cartas) {
            if (!carta.soyDelMismoPaloQueOtraCarta(primerCarta)) {
                return false;
            }
        }
        return true;
    }
    default void ordenarPorNumero(List<CartaDePoker> cartas) {
        cartas.sort(new Comparator<CartaDePoker>() {
            @Override
            public int compare(CartaDePoker card1, CartaDePoker card2) {
                return card2.compararNumero(card1);
            }
        });
    }


    default boolean esSecuencia(List<CartaDePoker> cartas) {
        if (cartas.size() < 2) {
            return true;
        }


        for (int i = 1; i < cartas.size(); i++) {
            if (!cartas.get(i).suValorEsSiguiente(cartas.get(i - 1)))  {
                return false;
            }
        }

        return true;
    }



   default Map<List<CartaDePoker>, Integer> contarPorNumero(List<CartaDePoker> cartas) {
        Map<List<CartaDePoker>, Integer> gruposDeNumeros = new LinkedHashMap<>();

        // grupos de cartas por rango
        List<CartaDePoker> grupoActual = new ArrayList<>();

        for (int i = 0; i < cartas.size(); i++) {
            CartaDePoker card = cartas.get(i);

            // si es la primer carta o matchea el numero anterior, se agrega al grupo
            if (i == 0 || card.compararNumero(cartas.get(i - 1)) == 0) {
                grupoActual.add(card);
            } else {
                // cuando el rango cambia, se guarda el grupo anterior y se empieza uno nuevo
                gruposDeNumeros.put(new ArrayList<>(grupoActual), grupoActual.size());
                grupoActual.clear();
                grupoActual.add(card);
            }
        }
            if (!grupoActual.isEmpty()) {
                gruposDeNumeros.put(new ArrayList<>(grupoActual), grupoActual.size());
            }

            return gruposDeNumeros;

    }


};









