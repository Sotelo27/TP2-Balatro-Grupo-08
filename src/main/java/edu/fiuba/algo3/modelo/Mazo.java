package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Mazo implements ITieneCartas {
    private List<CartaDePoker> cartas;
    private List<CartaDePoker> utilizadas;

    public Mazo() {
        this.cartas = new ArrayList<>();
    }

    public void addCard(CartaDePoker carta) {
        cartas.add(carta);
    }


    @Override
    public void tomarCarta(Mano mano) {
        int randomCard = new Random().nextInt(cartas.size());
        mano.recibirCard(cartas.remove(randomCard));

    }

    public void registrarUtilizadas(Mano mano, List<CartaDePoker> yaUtilizadas) {
        int randomCard = new Random().nextInt(cartas.size());

        for(CartaDePoker carta : yaUtilizadas) {
            mano.recibirCard(cartas.remove(randomCard));
            this.utilizadas.add(carta);

        }
    }

    public boolean tieneCartasSuficientes() {
        return (cartas.size() == 52);
    }


}
