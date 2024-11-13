package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;


public class Mano {
    private List<Card> mano;

    public Mano() {
        this.mano = new ArrayList<>();
    }

    public void recibirCard(Card card) {
        if(this.puedoAgregarCard()) {
            this.mano.add(card);
        }

    }

    public boolean puedoAgregarCard(){
        return (this.mano.size() >= 8);
    }

    public void seleccionarCarta(Jugada jugada, int cartaElegida){
        jugada.agregarCarta(mano.remove(cartaElegida));
    }

    public void deseleccionarCarta(Jugada jugada, int cartaElegida){

    }




}
