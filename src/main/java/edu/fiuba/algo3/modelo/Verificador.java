package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;


public abstract class Verificador implements MetodosLista {
    protected Verificador proximoVerificador;

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

    public abstract List <CartaDePoker> agregarPuntuables(List <CartaDePoker> cartasAPuntuar);


}
