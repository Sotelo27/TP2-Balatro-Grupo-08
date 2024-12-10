package edu.fiuba.algo3.modelo.CondicionesDeMejora;
import edu.fiuba.algo3.modelo.ICondicionMejora;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.*;



import java.util.Random;

public class ActivarAlAzar implements ICondicionMejora {
    private Random intGenerator;
    private String elemento;

    public ActivarAlAzar(Random intGenerator) {
        this.intGenerator = intGenerator;
    }

    @Override
    public void aplicarMejora(IMejorable mejorable, Mejora mejora, String contexto, String elemento) {
        int valor = Integer.parseInt(elemento); // Convertir el String a int
        int random = this.intGenerator.nextInt( valor);
        if(random == 0) {
            mejorable.aplicarMejora(mejora);
        }
    }
}
