package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;


public class Mano {
    private List<Card> mano;

    public Mano() {
        this.mano = new ArrayList<>();
    }

    public void recibirCard(Card card) {
        this.mano.add(card);
    }

    public boolean puedoAgregarCard(){
        return (this.mano.size() >= 8);
    }

    public Jugada generarJugada(List<Integer> listaDeCartas) {

        List cartasAJugar = new ArrayList<Cards>();

        for(int i = 0; i < listaDeCartas.size(); i++) {
            cartasAJugar.add(this.mano.get(listaDeCartas.get(i)));
        }
        Jugada jugada = new Jugada(cartasAJugar);
        return jugada;


    }
}
