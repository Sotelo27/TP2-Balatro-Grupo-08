package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;


public class Mano {
    private List<Carta> mano;
    private List<Carta> seleccion;

    public Mano() {
        this.mano = new ArrayList<>();
        this.seleccion = new ArrayList<>();
    }

    public void recibirCard(Carta carta) {
        if(this.puedoAgregarCard()) {
            this.mano.add(carta);
        }

    }

    public boolean puedoAgregarCard(){
        return (this.mano.size() <= 8);
    }

    public void seleccionarCarta(int cartaElegida){
        this.seleccion.add(mano.remove(cartaElegida));
    }




    public Jugada realizarJugada(){
        return new Jugada(seleccion);
    };




}
