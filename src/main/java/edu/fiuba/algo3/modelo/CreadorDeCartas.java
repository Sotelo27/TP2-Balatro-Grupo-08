package edu.fiuba.algo3.modelo;

public class CreadorDeCartas {
    private static final String[] PALOS = {"Corazones", "Diamantes", "Picas", "Espada"};
    private static final String[] NUMEROS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};


    public Mazo crearMazo() {
        Mazo mazo = new Mazo();
        for (String palo : PALOS) {
            for (String numero : NUMEROS) {
                CartaDePoker carta = new CartaDePoker(palo, numero);
                mazo.addCard(carta);
            }
        }
        return mazo;
    }
}