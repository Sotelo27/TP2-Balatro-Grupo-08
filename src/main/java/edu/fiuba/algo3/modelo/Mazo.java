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
    public Mazo(){
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
        if (!this.cartas.isEmpty()) {
            int randomCard = new Random().nextInt(this.cartas.size());
            CartaDePoker carta = cartas.get(randomCard);
            this.cartas.remove(randomCard);
            this.utilizadas.add(carta);
            return carta;
        }
        reutilizarCartasUsadas();
        return tomarCarta();
    }

    private void reutilizarCartasUsadas() {
        this.cartas.addAll(this.utilizadas);
    }

    public List<CartaDePoker> getCartas() {
        return cartas;
    }

    public boolean tieneCartasSuficientes() {
        return (cartas.size() == 52);
    }


}
