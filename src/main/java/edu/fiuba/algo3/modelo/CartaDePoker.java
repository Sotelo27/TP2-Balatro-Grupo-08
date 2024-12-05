package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadoDeCarta.NoSeleccionada;
import edu.fiuba.algo3.modelo.Mejoras.IMejorable;

import edu.fiuba.algo3.modelo.EstadoDeCarta.EstadoDeCarta;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;

import java.util.*;

public class CartaDePoker implements IMejorable {

    protected String numero;
    protected Mejora mejora;
    protected String palo;
    protected EstadoDeCarta estado;
    protected String nombre;
    protected int multiplicador;
    protected int puntos;
    protected PuntajeJugada puntaje;

    private static final List<String> ORDEN_NUMEROS = Arrays.asList(
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    );

    //Setters
    public CartaDePoker() {
    }

    public CartaDePoker(String nombre, String palo, String numero, int puntos, int multiplicador){
        this.estado = new NoSeleccionada();
        this.nombre = nombre;
        this.palo = palo;
        this.numero = numero;
        this.mejora = new Mejora() ;
        this.puntos = puntos;
        this.multiplicador = multiplicador;
    }

    public CartaDePoker(String nombre, String palo, String numero) {
        this.estado = new NoSeleccionada();
        this.nombre = nombre;
        this.palo = palo;
        this.numero = numero;
        this.mejora = new Mejora() ;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getNumero() {
        return this.numero;
    }


    @Override
    public void siContieneAplicarMejora(String contexto, String elemento, Mejora mejora) {

        if (elemento.equals(this.nombre)) {
            this.mejora = mejora;
        }

    }


    public void sumarAPuntajeJugada(PuntajeJugada puntajeJugada) {
        this.puntaje = new PuntajeJugada(this.puntos, this.multiplicador);
        this.mejora.seAplicaApuntaje(this.puntaje);
        this.estado.aplicarResultadoAPuntaje(this.puntaje, puntajeJugada);
    }

    public boolean soyDelMismoPaloQueOtraCarta(CartaDePoker cartaDePoker) {
        return cartaDePoker.soyDelMismoPaloQueOtraCarta(this.palo);

    }

    public boolean soyDelMismoPaloQueOtraCarta(String palo) {
        return this.palo.equals(palo);
    }

    public boolean soyDelMismoNumero(String numero) {
        return this.numero.equals(numero);
    }

    public boolean soyDelMismoNumero(CartaDePoker cartaDePoker) {
        return cartaDePoker.soyDelMismoNumero(this.numero);

    }

    public int compararNumero(int indiceOtraCarta) {
        int indiceEstaCarta = ORDEN_NUMEROS.indexOf(this.numero);
        return Integer.compare(indiceOtraCarta, indiceEstaCarta);
    }

    public int compararNumero(CartaDePoker otraCarta) {
        int indiceEstaCarta = ORDEN_NUMEROS.indexOf(this.numero);
        return otraCarta.compararNumero(indiceEstaCarta);
    }


    public boolean suValorEsSiguiente(CartaDePoker otraCarta) {
        int thisIndex = ORDEN_NUMEROS.indexOf(this.numero);
        return otraCarta.suValorEsSiguiente(thisIndex);
    }

    public boolean suValorEsSiguiente(int indiceOtraCarta) {
        int thisIndex = ORDEN_NUMEROS.indexOf(this.numero);
        return indiceOtraCarta == thisIndex - 1;
    }

   /* @Override
    public String toString() {

        return this.numero + " of " + this.palo + "    " + this.estado.esPuntuable;
    }*/

    public void changeState(EstadoDeCarta estadoDeCarta) {
        this.estado = estadoDeCarta;
    }

    public void aplicarMejora(Mejora mejora){
        this.mejora = mejora;
    }

}

