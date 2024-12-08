package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.Verificadores.Verificador;

import java.util.List;
import java.util.ArrayList;

public class Jugador implements IComprador {

    private String nombre;
    private Mano mano;
    private List<IMejorador> comodinesActivos;
    private List<IMejorador> tarotsActivos;
    private List<IMejorador> activables;
    private Mazo mazo;

    public Jugador(String nombre, Mazo mazo){
        this.nombre = nombre;
        this.mazo = mazo;
        this.mano = new Mano(mazo);
        this.comodinesActivos = new ArrayList<>();
        this.tarotsActivos = new ArrayList<>();
        this.activables = new ArrayList<>();
    }
    public void seleccionarCarta(CartaDePoker cartasSeleccionada){
        this.mano.seleccionarCarta(cartasSeleccionada);
    }


    public void seleccionarCarta(String  cartasSeleccionada){
        this.mano.seleccionarCarta(cartasSeleccionada);
    }

    public void recargarMano(){
        this.mano.recargarManoConMazo(mazo);
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
/*
    public void activarCarta(IMostrable carta, IMostrable sobre){ // Balatro
        switch (carta.esTipo()){
            case CartaDeTarot{
                carta.mejorar(sobre);
            }
            case CartaDePoker{
                carta.reemplazar(sobre);
            }
        }

        this.jugador.seleccionarCarta(sobre);
        this.jugador.activarCarta(carta);
    }




    public void activarCarta(IMostrable carta){ //jugador
        activables.forEach();
        activarCarta(carta);
    }
*/


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


    public void recibirActivable(IMejorador activable) throws ErrorSeExcedenLosLimitesDeActivables {
        if (this.activables.size() < 2) {
            this.activables.add(activable);
        }
        else{
            throw new ErrorSeExcedenLosLimitesDeActivables("Demasiados activables sin utilizar");
        }
    }
    public List<ICarta> getActivables() {
        List<ICarta> activables = new ArrayList<>();
        this.activables.forEach(activable -> activables.add((ICarta)activable));
        return activables;
    }


    @Override
    public void comprarCartaDeTarot(ICarta comprable) {
        recibirActivable((IMejorador) comprable);
    }

    @Override
    public void comprarComodin(ICarta comprable) {
        this.comodinesActivos.add((IMejorador) comprable);
    }

    @Override
    public void comprarCartaDePoker(ICarta comprable) {
        this.mano.recibirCard((CartaDePoker) comprable);
    }

    public List<ICarta> getComodinesActivos() {
        List<ICarta> comodines = new ArrayList<>();
        comodinesActivos.forEach(comodin -> comodines.add((ICarta)comodin));
        return comodines;
    }
}

