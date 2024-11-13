package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;


public class Mazo {
    private List<Card> cards;

    public Mazo() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }


}
