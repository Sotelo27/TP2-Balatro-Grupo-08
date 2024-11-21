package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class CartaDePoker implements IMejorable {
    String numero;
    Efecto efecto;
    String palo;


    public CartaDePoker(String palo, String numero) {
        this.palo = palo;
        this.numero = numero;
        this.efecto = new Efecto(this.devolverValor());
    }

    public int devolverValor() {
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
        efecto.calcularPuntajeCarta(puntajeJugada);

    }
}



