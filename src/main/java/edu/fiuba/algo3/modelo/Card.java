package edu.fiuba.algo3.modelo;
import java.util.List;

import java.util.ArrayList;


public class Card {
    private String rank;
    private Suit suit;
    private List<Enhancement>  enhancement;

    public Card(String rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
        this.enhancement = new ArrayList<>();

    }
}
