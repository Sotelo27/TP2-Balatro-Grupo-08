package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Mazo {
    private List<Card> cards;

    public Mazo() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }



    public void repartir(Mano mano) {
        int randomCard = new Random().nextInt(cards.size());

        while(mano.puedoAgregarCard()){
            mano.recibirCard(cards.remove(randomCard));
        }
    }


}
