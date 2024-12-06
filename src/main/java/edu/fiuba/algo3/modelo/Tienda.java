package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.IMejorador;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    List<IMejorador> cartasEspeciales;
    CartaDePoker carta;

    public void setCartasEspeciales(List <IMejorador> cartasEspeciales) {this.cartasEspeciales = cartasEspeciales;}

    public void setCarta(CartaDePoker carta) {
        this.carta = carta;
    }

    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (IMejorador especiales : cartasEspeciales) {
            System.out.println(especiales.getNombre());
            items.add(especiales.getNombre());
        }
        System.out.println(carta.getNombre());
        items.add(carta.getNombre());
        return items;
    }
}
