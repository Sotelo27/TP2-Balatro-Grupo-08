package edu.fiuba.algo3.unitarias;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.SinRestriccion;
import edu.fiuba.algo3.modelo.ICarta;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.MultiplicaMultiplicador;
import edu.fiuba.algo3.modelo.Mejoras.SumaAMultiplicador;
import edu.fiuba.algo3.modelo.Tienda;
import org.junit.Test;
import edu.fiuba.algo3.modelo.CartaDePoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTienda {
    @Test
    public void test01SePideNombreDeItemYDevuelveCorrectamente(){
        Tienda tienda = new Tienda();
        List<ICarta> especiales = new ArrayList<>();
        CartaDePoker cartaPoker= new CartaDePoker("5 de Treboles", "Trebol", "5", 5,1);
        Comodin comodinX4 = new Comodin("Comodinx4", new Mejora(1, 4, new MultiplicaMultiplicador() ), new SinRestriccion(), "", "");
        Comodin comodiSuma4mult = new Comodin("ComodinSuma", new Mejora(1, 4, new SumaAMultiplicador() ), new SinRestriccion(),"", "");
        especiales.add(comodinX4);
        especiales.add(comodiSuma4mult);
        tienda.setCartas(especiales);
        List<String> itemsObtenidos  = new ArrayList<>();
        tienda.getItems().forEach(each -> itemsObtenidos.add(each.getNombre()));
        List<String> itemEsperados = Arrays.asList("Comodinx4", "ComodinSuma","5 de Treboles");
        assert itemEsperados.containsAll(itemsObtenidos);
    }
    /*
    * Validar que las cartas de cada tienda se muestran correctamente
    * Validar que las cartas pueden ser obtenidas
    * Validar que las cartas pueden ser seleccionadas
    * Consultar como hacer para leer los detalles de cada carta que se ofrezca
    * Validar que la misma tienda no puede ser utilizada dos veces
    * */
}
