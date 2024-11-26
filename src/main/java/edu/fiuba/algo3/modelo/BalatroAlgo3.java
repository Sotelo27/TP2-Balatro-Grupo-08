package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Estados.EstadoJuego;
import edu.fiuba.algo3.repositorios.*;

import java.io.IOException;
import java.util.List;

public class BalatroAlgo3{
    private Jugador jugador;
    private List<Ronda> rondas;
    private Mazo mazo;


    public BalatroAlgo3(String nombreDelJugador, LectorDeJSON creadorDeObjetos) throws IOException {

         this.mazo.setMazo(creadorDeObjetos.construirMazo());
         this.jugador = new Jugador(nombreDelJugador, mazo);
         this.rondas = creadorDeObjetos.construirBalatro();
    }

    public void iniciarJuego(){
    }

    public void seleccionarCartaDePoker(String nombre){
    }

    public void activarTarot(String nombre){
    }

    public void activarComodin(String nombre){
    }

    public Puntaje verPuntajeDeRonda(){ return new Puntaje();}

    public void realizarJugada(){
        // this.jugador.realizarJugada(this.ronda);
    }

    public void realizarDescarte(){
        // this.jugador.realizarDescarte(this.ronda)
    }
    public void setEstado(EstadoJuego estado){};
}