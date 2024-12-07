package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.IMejorador;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    List<IMostrable> cartas;

    public void setCartas(List <IMostrable> cartasEspeciales) {this.cartas = cartasEspeciales;}

    public List<IMostrable> getItems() {

        return cartas;
    }
}
