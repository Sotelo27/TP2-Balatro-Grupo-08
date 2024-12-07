package edu.fiuba.algo3.modelo;

import java.util.List;

public class Tienda {
    List<ICarta> cartas;

    public void setCartas(List <ICarta> cartasEspeciales) {this.cartas = cartasEspeciales;}

    public List<ICarta> getItems() {

        return cartas;
    }
    public void comprar(IComprable carta, IComprador comprador) {
        carta.asignarAComprador(comprador);
    }
}
