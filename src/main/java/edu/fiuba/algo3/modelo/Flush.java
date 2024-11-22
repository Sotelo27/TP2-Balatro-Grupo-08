package edu.fiuba.algo3.modelo;

import java.util.List;

public class Flush extends CombinacionDePoker{

    public Flush(List<CartaDePoker> cartas) {
        super(cartas);
        this.nombre = "Flush";
        this.efecto = new Efecto(35, 4);


        for(CartaDePoker carta : cartas){
            carta.changeState(new Puntuable());
        }






    }
}
