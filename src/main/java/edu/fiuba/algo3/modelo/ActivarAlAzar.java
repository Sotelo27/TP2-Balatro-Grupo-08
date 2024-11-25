package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.*;


import java.util.Random;

public class ActivarAlAzar implements ICondicionMejora{
    private int probabilidad;
    private final String contexto = "1 en";

    public ActivarAlAzar(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    @Override
    public boolean validarCondicion(IMejorable mejorable) {
        if(mejorable.contiene("1 en", "")) {
            int random = new Random().nextInt(this.probabilidad);

            return (random == 0);
        }
        return false;
    }
}
