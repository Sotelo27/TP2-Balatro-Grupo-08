package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.IMejorador;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    List<IMejorador> cartasEspeciales;
    CartaDePoker carta;

    public void setCartasEspeciales(List <IMejorador> cartasEspeciales) {this.cartasEspeciales = cartasEspeciales;}

    public CartaDePoker getCarta() {
        return carta;
    }

   // public IMejorador getCarta() {
        //return carta;
    //}

    public IMejorador seleccionarCartaEspecial(String cartaEspecial){
        IMejorador cartaObtenida = null;
        for (IMejorador especiales : cartasEspeciales) {
            //if (especiales.tieneNombre(cartaEspecial)){
                //cartaObtenida = especiales;
            //}
        }
        return cartaObtenida;
    };

    public void setCarta(CartaDePoker carta) {
        this.carta = carta;
    }
   public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (IMejorador especiales : cartasEspeciales) {
            //items.add(especiales.getNombre());
        }
        items.add(carta.getNombre());
        return items;
    }
}
