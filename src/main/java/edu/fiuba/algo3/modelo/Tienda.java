package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Tienda {
    List<Comodin> comodines;
    List<TarotPrueba> tarots;
    CartaDePoker carta;

    public List<Comodin> getComodines() {
        return comodines;
    }

    public void setComodines(List<Comodin> comodines) {
        this.comodines = comodines;
    }

    public List<TarotPrueba> getTarots() {
        return tarots;
    }

    public void setTarots(List<TarotPrueba> tarots) {
        this.tarots = tarots;
    }

    public CartaDePoker getCarta() {
        return carta;
    }

    public void setCarta(CartaDePoker carta) {
        this.carta = carta;
    }
}
