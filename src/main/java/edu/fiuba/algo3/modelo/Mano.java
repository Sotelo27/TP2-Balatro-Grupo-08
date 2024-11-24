package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.List;


public class Mano {
    private ArrayList<CartaDePoker> mano = new ArrayList<>();
    private ArrayList<CartaDePoker> seleccion = new ArrayList<>();

    public Mano(ITieneCartas mazo){
        this.recargarManoConMazo(mazo);
    }

    public void recibirCard(CartaDePoker carta) {

        if(this.puedoAgregarCard()) {
            this.mano.add(carta);
        }else{
            throw new ErrorManoSeExcedioDeCartas("No se puede agregar una carta");
        }

    }

    public void recargarManoConMazo(Mazo mazo){
        while(this.puedoAgregarCard()){
            this.mano.add(mazo.tomarCarta());
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
    public List<CartaDePoker> realizarDescarte(Ronda ronda){
        if (this.seleccion.isEmpty()) {
            throw new ErrorJugadaVacia("No hay cartas seleccionadas");
        }
        Descarte descarte = new Descarte(this.seleccion);
        return ronda.agregarAccion(descarte);
    }

    public bool realizarJugada(Ronda ronda, List<CartaDeTarot> cartasDeTarot, List<Comodin> comodines){
        if (this.seleccion.isEmpty()) {
            throw new ErrorJugadaVacia("No hay cartas seleccionadas");
            return false;
        }
        Jugada jugada = new Jugada(this.seleccion);

        jugada.aplicarTarots(cartasDeTarot);
        for(Comodin comodin : comodines){
            comodon.mejorar(jugada)
        }
        return true;
    };









}
