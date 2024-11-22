package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;


public class Mano {
    private ArrayList<CartaDePoker> mano = new ArrayList<>();
    private ArrayList<CartaDePoker> seleccion = new ArrayList<>();

    //agregar constructor

    public void recibirCard(CartaDePoker carta) {
        if(this.puedoAgregarCard()) {
            this.mano.add(carta);
        }

    }

    public boolean puedoAgregarCard(){
        return (this.mano.size() <= 8);
    }

    public void seleccionarCarta(CartaDePoker cartaElegida){
        this.seleccion.add(cartaElegida);
    }

    public Jugada realizarJugada(){
        if (this. seleccion.isEmpty()) {
            throw new ErrorJugadaVacia("No hay cartas seleccionadas");
        }
        return new Jugada(this.seleccion);
    };




}
