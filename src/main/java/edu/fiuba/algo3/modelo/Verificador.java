package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;


public abstract class Verificador implements MetodosLista {
    protected Verificador proximoVerificador;
    protected List <CartaDePoker> listaPuntuables;

    public Verificador() {
    }

    public CombinacionDePoker pasarAlSiguiente(List <CartaDePoker> cartas) {
        if (proximoVerificador != null) {
            return proximoVerificador.verificar(cartas);
        }
        return new HighCard(cartas);
    };

    public abstract CombinacionDePoker verificar(List <CartaDePoker> cartas);

    public abstract boolean esDeTipo (List <CartaDePoker> cartas);

    public void agregarPuntuables(List <CartaDePoker> cartasAPuntuar) {
        for (CartaDePoker carta : cartasAPuntuar) {
            carta.changeState(new Puntuable());
            this.listaPuntuables.addAll(cartasAPuntuar);
        }
        ;
    }


}
