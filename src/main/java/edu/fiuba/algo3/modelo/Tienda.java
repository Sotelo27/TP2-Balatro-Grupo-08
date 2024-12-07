package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Tienda {
    Comodin comodines;
    List<CartaDeTarot> tarots;
    CombinacionDeComodines combinaciones;
    CartaDePoker carta;

    public void setComodin(Comodin comodines) {
        this.comodines = comodines;
    }

    public void setCombinacion(CombinacionDeComodines combinaciones) {
        this.combinaciones = combinaciones;
    }

    public List<CartaDeTarot> getTarots() {
        return tarots;
    }

    public void setTarots(List<CartaDeTarot> tarots) {
        this.tarots = tarots;
    }

    public CartaDePoker getCarta() {
        return carta;
    }

    public void setCarta(CartaDePoker carta) {
        this.carta = carta;
    }
}
