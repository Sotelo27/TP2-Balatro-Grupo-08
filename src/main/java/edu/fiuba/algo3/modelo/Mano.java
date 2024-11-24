package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.List;


public class Mano {
    private ArrayList<CartaDePoker> mano = new ArrayList<>();
    private ArrayList<CartaDePoker> seleccion = new ArrayList<>();


    //agregar constructor

    public void recibirCard(CartaDePoker carta) {

        if(this.puedoAgregarCard()) {
            this.mano.add(carta);
        }else{
            throw new ErrorManoSeExcedioDeCartas("No se puede agregar una carta");
        }

    }

    public void recargarManoConMazo(Mazo mazo){
        while(this.puedoAgregarCard()){
            mazo.tomarCarta(this);
        }
    }

    private boolean puedoAgregarCard(){
        return (this.mano.size() <= 8);
    }

    public void seleccionarCarta(CartaDePoker cartaElegida){
        if(!this.mano.remove(cartaElegida)){
            throw new ErrorNoPuedeSelecionarCartasQueNoEstenEnMano("No se puede seleccionar una carta porque no esta en el mazo");
        }

        this.seleccion.add(cartaElegida);
    }



    public Jugada realizarJugadaConComodines(List<Comodin> comodines){
        if (this.seleccion.isEmpty()) {
            throw new ErrorJugadaVacia("No hay cartas seleccionadas");
        }




        return new Jugada(this.seleccion);
    };

    public Jugada realizarJugada(Ronda ronda,List<Comodin> comodines, List<CartaDeTarot> cartasDeTarot){
        if (this.seleccion.isEmpty()) {
            throw new ErrorJugadaVacia("No hay cartas seleccionadas");
        }
        Jugada jugada = new Jugada(this.seleccion);

        jugada.aplicarTarots(cartasDeTarot);



        return jugada;
    };









}
