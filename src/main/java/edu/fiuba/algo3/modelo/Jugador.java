package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.modelo.Mejoras.*;
import java.util.List;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Mano mano;
    private List<IMejorador> comodinesActivos;
    private List<IMejorador> tarotsActivos;
    private Mazo mazo;

    public Jugador(String nombre, Mazo mazo){
        this.nombre = nombre;
        this.mazo = mazo;
        this.mano = new Mano(mazo);
        this.comodinesActivos = new ArrayList<>();
        this.tarotsActivos = new ArrayList<>();
    }
    public void seleccionarCarta(CartaDePoker cartasSeleccionada){
        this.mano.seleccionarCarta(cartasSeleccionada);
    }


    public void seleccionarCarta(String  cartasSeleccionada){
        this.mano.seleccionarCarta(cartasSeleccionada);
    }

    public void realizarJugada(Ronda ronda){
        if (this.mano.realizarJugada(ronda, this.tarotsActivos, this.comodinesActivos)) {
            this.mano.recargarManoConMazo(this.mazo);
        }

    }
    public void realizarDescarte(Ronda ronda){
        if(this.mano.realizarDescarte(ronda,this.comodinesActivos) ){
            this.mano.recargarManoConMazo(this.mazo);
        }

    }
    public List<String> getCartasEnMano(){
        return this.mano.getCartas();
    }

    public void activarTarot(CartaDeTarot tarot){
        this.mano.activarTarot(tarot);
        this.tarotsActivos.add(tarot);
    }

    public void activarTarot(CartaDeTarot tarot, CartaDePoker cartaObjetivo){
        this.mano.activarTarotSobreCarta(tarot, cartaObjetivo);
        this.tarotsActivos.add(tarot);
    }
    public void activarComodin(IMejorador mejorador){
        this.comodinesActivos.add(mejorador);
    }

    public List<String> getCartasSeleccionadas() {
        return this.mano.getSeleccionadas();
    }
}
