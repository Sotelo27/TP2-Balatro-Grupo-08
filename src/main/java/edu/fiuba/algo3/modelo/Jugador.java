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
        this.mano = new Mano();
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

    public List<ICarta> getCartasEnMano(){
        return this.mano.getCartas();
    }

    public void activarTarot(ICarta tarot, ICarta cartaObjetivo){
        for (IMejorador mejorador : new ArrayList<>(this.activables)){
            if (mejorador.getNombre().equals(tarot.getNombre())){
                this.mano.activarTarotSobreCarta((CartaDeTarot) mejorador,cartaObjetivo);
                this.tarotsActivos.add(mejorador);
                this.activables.remove(mejorador);
                System.out.println("Activado");
            }

        }
    }

    public void activarTarot(ICarta tarot){
        this.mano.activarTarot((CartaDeTarot) tarot);
        this.tarotsActivos.add((IMejorador) tarot);
        this.activables.remove(tarot);
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
        this.activables.forEach(activable -> activables.add(activable.getCarta()));
        return activables;
    }

    @Override
    public void comprarCartaDeTarot(IMejorador comprable) {
        recibirActivable(comprable);
    }

    @Override
    public void comprarComodin(IMejorador comprable) {
        this.comodinesActivos.add(comprable);
    }

    @Override
    public void comprarCartaDePoker(CartaDePoker comprable) {
        this.mano.recibirCard(comprable);
    }

    public List<ICarta> getComodinesActivos() {
        List<ICarta> comodines = new ArrayList<>();
        comodinesActivos.forEach(comodin -> comodines.add(comodin.getCarta()));
        return comodines;
    }

    public void vaciarMano() {
        this.mano.vaciar();
    }
}

