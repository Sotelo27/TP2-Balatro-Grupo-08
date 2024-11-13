package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;


public class Mano {
    private List<Card> mano;

    public Mano() {
        mano = new ArrayList<>();
    }

    public void recibirCard(Card card) {
        if(mano.size() >= 8)
            return;

        mano.add(card);
    }

    public void generarJugada(List<Integer> listaDeCartas) {

        List cartasAJugar = new ArrayList<Cards>();

        for(int i = 0; i < listaDeCartas.size(); i++) {
            cartasAJugar.add(this.mano.get(listaDeCartas.get(i)));
        }
        Jugada jugada = new Jugada(cartasAJugar);


    }
}
