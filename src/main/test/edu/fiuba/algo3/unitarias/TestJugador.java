package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.*;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.modelo.Mejoras.*;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TestJugador {

    /*
    * Replicar todas las pruebas de integracion que involucraron al jugador
    * Validar que el jugador muestra correctamente su informacion interna sobre los efectos activos de comodines y tarots
    * */
/*
    @Test
    public void test01JugadorRecibe1TarotCorrectamente() throws ErrorSeExcedenLosLimitesDeActivables {
        Mazo mazoMock = mock(Mazo.class);

        Jugador jugador = new Jugador("Joaquin", mazoMock);
        String nombreBuscado = "un Nombre";
        Mejora multiplicaX8 = new Mejora(1, 8, new MultiplicaMultiplicador());
        IMejorador comodin = new Comodin(nombreBuscado, multiplicaX8, new SinRestriccion(),"", "");;

        jugador.recibirActivable(comodin);
        List<String> comdinesObtenidos = jugador.getActivables();

        assert(comdinesObtenidos.contains(nombreBuscado));
    }

    @Test
    public void test02JugadorRecibe1ComodinCorrectamente() throws ErrorSeExcedenLosLimitesDeActivables {
        Jugador jugador = new Jugador("Joaquin", new Mazo());
        String nombreBuscado = "un Nombre";
        IMejorador tarot = new CartaDeTarot(nombreBuscado, new Mejora(1, 2,new MultiplicaMultiplicador()),new RestriccionACarta(),"", "");

        jugador.recibirActivable(tarot);
        List<String> tarotsObtenidos = jugador.getActivables();

        assert tarotsObtenidos.contains(nombreBuscado);
    }

 */
}
