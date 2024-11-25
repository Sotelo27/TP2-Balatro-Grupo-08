package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.IMejorable;

import edu.fiuba.algo3.modelo.EstadoDeCarta;

import java.util.Objects;
import java.util.*;

public class CartaDePoker implements IMejorable {

    protected String numero;
    protected Efecto efecto;
    protected String palo;
    protected EstadoDeCarta estado;
    protected String nombre;
    protected int multiplicador;
    protected int puntos;

    private static final List<String> ORDEN_NUMEROS = Arrays.asList(
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    );

    //Setters
    public CartaDePoker() {
    }

    public CartaDePoker(String nombre, String palo, String numero, Efecto efecto) {
        this.estado = new NoSeleccionada();
        this.nombre = nombre;
        this.palo = palo;
        this.efecto = efecto;
        this.numero = numero;


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
        this.efecto = new Efecto(puntos);
    }

    public void setMultiplicador(int multiplicador) {
    }

    public String getNombre() {
        return this.nombre;
    }



    @Override
    public void siContieneAplicarMejora(String contexto, String elemento, Mejora mejora){

        if (elemento.equals(this.nombre)){
            this.efecto.recibirMejora(mejora);
        }

    }


    public void sumarAPuntajeJugada(PuntajeJugada puntajeJugada) {
        this.estado.aplicarResultadoAPuntaje(this.efecto, puntajeJugada);

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

    @Override
    public String toString() {

        return this.numero + " of " + this.palo + "    " + this.estado.esPuntuable;
    }

    public void changeState(EstadoDeCarta estadoDeCarta) {
        this.estado = estadoDeCarta;
    }

}

