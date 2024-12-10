package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.modelo.CondicionesDeMejora.RestriccionACarta;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.SinRestriccion;
import edu.fiuba.algo3.modelo.ErrorSeExcedenLosLimitesDeActivables;
import edu.fiuba.algo3.modelo.ICarta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import edu.fiuba.algo3.modelo.Mejoras.IMejorador;
import edu.fiuba.algo3.modelo.Mejoras.MultiplicaMultiplicador;
import org.junit.Test;

import java.util.List;

public class TestJugador {

    /*
    * Replicar todas las pruebas de integracion que involucraron al jugador
    * Validar que el jugador muestra correctamente su informacion interna sobre los efectos activos de comodines y tarots
    * */

    @Test
    public void test01JugadorRecibe1TarotCorrectamente() throws ErrorSeExcedenLosLimitesDeActivables {
        Jugador jugador = new Jugador("Joaquin", new Mazo());
        String nombreBuscado = "un Nombre";
        Mejora multiplicaX8 = new Mejora(1, 8, new MultiplicaMultiplicador());
        IMejorador comodin = new Comodin(nombreBuscado, multiplicaX8, new SinRestriccion(),"", "");;

        //jugador.comprarCartaDeTarot(comodin);
        List<ICarta> comdinesObtenidos = jugador.getActivables();

        assert comdinesObtenidos.contains(nombreBuscado);
    }

    @Test
    public void test02JugadorRecibe1ComodinCorrectamente() throws ErrorSeExcedenLosLimitesDeActivables {
        Jugador jugador = new Jugador("Joaquin", new Mazo());
        String nombreBuscado = "un Nombre";
        //IMejorador tarot = new CartaDeTarot(nombreBuscado, new Mejora(1, 2,new MultiplicaMultiplicador()),new RestriccionACarta(),"", "");

        //jugador.comprarComodin(tarot);
        List<ICarta> comodinesObtenidos = jugador.getActivables();

        assert comodinesObtenidos.contains(nombreBuscado);
    }
}
