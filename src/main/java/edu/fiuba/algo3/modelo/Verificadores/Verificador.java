package edu.fiuba.algo3.modelo.Verificadores;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.MetodosLista;
import edu.fiuba.algo3.modelo.EstadoDeCarta.Puntuable;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.CombinacionDePoker;

import java.util.ArrayList;
import java.util.List;


public abstract class Verificador implements MetodosLista {
    protected Verificador proximoVerificador;
    protected List <CartaDePoker> listaPuntuables = new ArrayList<CartaDePoker>();

    public Verificador() {
    }

    public CombinacionDePoker pasarAlSiguiente(List <CartaDePoker> cartas) {
        return proximoVerificador.verificar(cartas);
    };

    public abstract CombinacionDePoker verificar(List <CartaDePoker> cartas);

    public abstract boolean esDeTipo (List <CartaDePoker> cartas);

    public void agregarPuntuables(List <CartaDePoker> cartasAPuntuar) {
        for (CartaDePoker carta : cartasAPuntuar) {
            carta.changeState(new Puntuable());
            this.listaPuntuables.addAll(cartasAPuntuar);
        }

    }
}
