package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoras.*;

import java.util.ArrayList;
import java.util.List;



public class Mano {
    private ArrayList<CartaDePoker> mano = new ArrayList<>();
    private ArrayList<CartaDePoker> seleccion = new ArrayList<>();


    public Mano(){

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
        return (this.mano.size() < 8);
    }

    public void seleccionarCarta(String cartaElegida){
        CartaDePoker cartaSeleccionada = this.mano.stream().filter(carta -> carta.getNombre().equals(cartaElegida)).findFirst().get();
        this.mano.remove(cartaSeleccionada);
        this.seleccion.add(cartaSeleccionada);
    }

    public void seleccionarCarta(CartaDePoker cartaElegida){
        if(!this.mano.remove(cartaElegida)){
            throw new ErrorNoPuedeSelecionarCartasQueNoEstenEnMano("No se puede seleccionar una carta porque no esta en el mazo");
        }

        this.seleccion.add(cartaElegida);
    }
    public boolean realizarDescarte(Ronda ronda, List<IMejorador> comodines){
        if (this.seleccion.isEmpty()) {
            throw new ErrorJugadaVacia("No hay cartas seleccionadas");
        }

        Descarte descarte = new Descarte(new ArrayList<>(this.seleccion));
        for(IMejorador comodin : comodines){
                    comodin.mejorar(descarte);
        }

        this.seleccion.clear();
        return ronda.agregarAccion(descarte);
    }

    public boolean realizarJugada(Ronda ronda, List<IMejorador> cartasDeTarot, List<IMejorador> comodines){
        if (this.seleccion.isEmpty()) {
            throw new ErrorJugadaVacia("No hay cartas seleccionadas");
        }
        Jugada jugada = new Jugada(new ArrayList<>(this.seleccion));

        jugada.aplicarTarots(cartasDeTarot);
        for(IMejorador comodin : comodines){
            comodin.mejorar(jugada);
        }

        this.seleccion.clear();
        return ronda.agregarAccion(jugada);
    }

    public void activarTarotSobreCarta(CartaDeTarot cartaDeTarot, ICarta carta){
        cartaDeTarot.setSobre(carta);
    }

    public List<ICarta> getCartas(){
        List<ICarta> cartas = new ArrayList<>();
        for(CartaDePoker carta : this.mano){
            cartas.add(carta);
        }
        return cartas;
    }

    public void activarTarot(CartaDeTarot cartaDeTarot){
        CartaDePoker cartaObjetivo = this.seleccion.get(0);
        cartaDeTarot.setSobre(cartaObjetivo);
        deseleccionar(cartaObjetivo);
    }

    private void deseleccionar(CartaDePoker cartaObjetivo) {
        this.seleccion.remove(cartaObjetivo);
        this.mano.add(cartaObjetivo);
        System.out.println("Carta " + cartaObjetivo.getNombre() + " deseleccionada");
    }

    public List<String> getSeleccionadas() {
        List<String> cartas = new ArrayList<>();
        for(CartaDePoker carta : this.seleccion){
            cartas.add(carta.getNombre());
        }
        return cartas;
    }

    public void vaciar() {
        this.mano.clear();
    }
}
