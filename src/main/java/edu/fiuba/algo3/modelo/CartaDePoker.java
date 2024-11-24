package edu.fiuba.algo3.modelo;

import java.util.Objects;
import java.util.*;

public class CartaDePoker implements IMejorable {

    protected String numero;
    protected Efecto efecto;
    protected String palo;
    protected EstadoDeCarta estado;

    private static final List<String> ORDEN_NUMEROS = Arrays.asList(
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    );

    public CartaDePoker(String palo, String numero) {
        this.palo = palo;
        this.numero = numero;
        this.efecto = new Efecto(this.devolverValor());
        this.estado = new NoSeleccionada();
    }

    public int devolverValor() {
        // esto debería volar al usar factory
        int valor = 0;
        if (Objects.equals(this.numero, "J") || Objects.equals(this.numero, "Q") || Objects.equals(this.numero, "K")) {
            valor = 10;
            return valor;
        }
        if (Objects.equals(this.numero, "A")) {
            valor = 11;
            return valor;
        }
        return Integer.parseInt(this.numero);
    }

    @Override
    public void recibirMejora(Mejora mejora) {
        efecto.recibirMejora(mejora);
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

    public boolean soyDelMismoNumero (String numero) {
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
        return  indiceOtraCarta == thisIndex - 1;
    }

    @Override
    public String toString() {

        return this.numero + " of " + this.palo + "    " + this.estado.esPuntuable ;
    }

    public void changeState(EstadoDeCarta estadoDeCarta){
        this.estado = estadoDeCarta;
    }
