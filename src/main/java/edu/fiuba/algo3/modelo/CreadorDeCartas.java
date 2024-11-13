package edu.fiuba.algo3.modelo;

public class CreadorDeCartas {
    private static final Suit[] SUITNAME = {new Hearts() ,new Diamonds() , new Clubs(), new Spades()};
    private static final String[] RANK = {"A", "2", "3", "4", "5", "6", "7", "8", "9","10" ,"J", "Q", "K"};

    public Mazo crearMazo() {
        Mazo mazo = new Mazo();
        for(Suit suit: SUITNAME) {
            for (String rank: RANK) {
                mazo.addCard(new Card(rank, suit));


            }

        }
        return mazo;

    }

}
