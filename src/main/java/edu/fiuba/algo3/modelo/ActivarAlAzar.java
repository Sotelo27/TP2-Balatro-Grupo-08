package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.*;



import java.util.Random;

public class ActivarAlAzar implements ICondicionMejora{
    private int probabilidad;
    private final String contexto = "Jugada";

    public ActivarAlAzar(int probabilidad) {
        this.probabilidad = probabilidad;
    }

   @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora){
        int random = new Random().nextInt(this.probabilidad);
        if(random == 0) {
            mejorable.siContieneAplicarMejora(this.contexto, "", mejora);

        }
    }

}
