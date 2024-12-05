package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Mazo implements ITieneCartas {
    private List<CartaDePoker> cartas;
    private List<CartaDePoker> utilizadas;

    public Mazo(List<CartaDePoker> cartas) {
        this.cartas = cartas;
        this.utilizadas = new ArrayList<>();
    }

    //Setters

    public void setMazo(List<CartaDePoker> mazo) {
        this.cartas = mazo;
    }

    public void addCard(CartaDePoker carta) {
        cartas.add(carta);
    }

    @Override
    public CartaDePoker tomarCarta() {
        int randomCard = new Random().nextInt(this.cartas.size());
        CartaDePoker carta = cartas.get(randomCard);
        this.utilizadas.add(carta);
        return carta;
    }

    public boolean tieneCartasSuficientes() {
        return (cartas.size() == 52);
    }


}
