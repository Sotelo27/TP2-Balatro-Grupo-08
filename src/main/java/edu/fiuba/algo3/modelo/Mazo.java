package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Mazo {
    private List<CartaDePoker> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
    }

    //Setters

    public void setMazo(List<CartaDePoker> mazo) {
        this.cartas = mazo;
    }

    public void addCard(CartaDePoker carta) {
        cartas.add(carta);
    }

    public List<CartaDePoker> getCartas() {
        return cartas;
    }

    public void repartir(Mano mano) {
        int randomCard = new Random().nextInt(cartas.size());

        while(mano.puedoAgregarCard()){
            mano.recibirCard(cartas.remove(randomCard));
        }
    }

    public boolean tieneCartasSuficientes() {
        return (cartas.size() == 52);
    }


}
